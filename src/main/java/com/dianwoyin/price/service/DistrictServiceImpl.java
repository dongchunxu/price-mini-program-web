package com.dianwoyin.price.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dianwoyin.price.api.DistrictService;
import com.dianwoyin.price.api.RedisService;
import com.dianwoyin.price.vo.response.DistrictListResponseVO;
import com.dianwoyin.price.constants.RedisCacheKey;
import com.dianwoyin.price.entity.DistrictDict;
import com.dianwoyin.price.mapper.DistrictDictMapper;
import com.dianwoyin.price.utils.BaseBeanUtils;
import com.dianwoyin.price.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class DistrictServiceImpl implements DistrictService {

    private static final String URL = "https://restapi.amap.com/v3/config/district?keywords=&subdistrict=3&key=f7b2f56bbb264316ec738819711f6ee3";

    @Autowired
    private RedisService redisService;
    @Autowired
    private DistrictDictMapper districtDictMapper;

    @Override
    public void init() {
        String s = HttpClientUtils.doGet(URL);
        JSONObject jsonObject = JSON.parseObject(s);

        loopDistrict(jsonObject.getJSONArray("districts"), 0);
    }

    @Override
    public List<DistrictListResponseVO> getChildrenByParentId(Integer parentId) {
        if (parentId == null || parentId < 1) {
            return Collections.emptyList();
        }
        List<DistrictDict> districtDicts = districtDictMapper.selectByParentId(parentId);
        return BaseBeanUtils.copyProperty(districtDicts, DistrictListResponseVO.class);
    }

    @Override
    public Map<String, List<DistrictListResponseVO>> getDistrictByLevel(Integer level) {
        Map<String, List<DistrictListResponseVO>> pinyinToDistrictMap = redisService.getObject(RedisCacheKey.DISTRICT_CITY_ALL, Map.class);
        if (!CollectionUtils.isEmpty(pinyinToDistrictMap)) {
            return pinyinToDistrictMap;
        }

        // 获取该级所有的行政区划
        List<DistrictDict> districtDictList = districtDictMapper.selectByLevel(level);
        List<DistrictListResponseVO> districtListRespBOList = BaseBeanUtils.copyProperty(districtDictList, DistrictListResponseVO.class);

        // 所有的行政区获取拼音，用于下面排序
        districtListRespBOList.forEach(e-> {
            try {
                String pinyin = PinyinHelper.toHanYuPinyinString(e.getName(), new HanyuPinyinOutputFormat(), "", false);
                e.setFirstLetter(pinyin.substring(0, 1).toUpperCase());
                e.setPinyin(pinyin);
            } catch (BadHanyuPinyinOutputFormatCombination exp) {
                log.error("pinyin handle error!", exp);
            }
        });

        // 以拼音排序
        pinyinToDistrictMap = districtListRespBOList
                .stream().sorted(Comparator.comparing(DistrictListResponseVO::getPinyin))
                .collect(Collectors.groupingBy(DistrictListResponseVO::getFirstLetter));
        redisService.setObject(RedisCacheKey.DISTRICT_CITY_ALL, pinyinToDistrictMap);
        return pinyinToDistrictMap;
    }


    private void loopDistrict(JSONArray jsonArray, Integer parentId) {
        if (jsonArray == null || jsonArray.size() == 0) {
            return;
        }
        Map<String, Integer> levelMap = new HashMap<>();
        levelMap.put("country", 1);
        levelMap.put("province", 2);
        levelMap.put("city", 3);
        levelMap.put("district", 4);
        levelMap.put("street", 5);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            DistrictDict districtDict = new DistrictDict();
            districtDict.setCityCode(jsonObject.getString("citycode"));
            districtDict.setName(jsonObject.getString("name"));
            districtDict.setAdCode(jsonObject.getString("adcode"));
            districtDict.setLevel(levelMap.get(jsonObject.getString("level")));
            districtDict.setParentId(parentId);
            districtDict.setCreateTime(new Date());
            districtDict.setUpdateTime(new Date());
            districtDict.setDeleted(false);
            districtDictMapper.insert(districtDict);
            loopDistrict(jsonObject.getJSONArray("districts"), districtDict.getId());
        }
    }

}
