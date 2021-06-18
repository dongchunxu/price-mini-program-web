package com.dianwoyin.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dianwoyin.price.mapper.DistrictDictMapper;
import com.dianwoyin.price.model.DistrictDict;
import com.dianwoyin.price.respository.DistrictRepository;
import com.dianwoyin.price.service.DistrictService;
import com.dianwoyin.price.service.RedisService;
import com.dianwoyin.price.constants.RedisCacheKey;
import com.dianwoyin.price.utils.HttpClientUtils;
import com.dianwoyin.price.utils.PriceBeanUtils;
import com.dianwoyin.price.vo.response.distirct.DistrictListResponse;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
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
    private DistrictRepository districtRepository;

    @Override
    public void init() {
        String s = HttpClientUtils.doGet(URL);
        JSONObject jsonObject = JSON.parseObject(s);

        loopDistrict(jsonObject.getJSONArray("districts"), 0);
    }

    @Override
    public List<DistrictListResponse> getChildrenByParentId(Integer parentId) {
        if (parentId == null || parentId < 1) {
            return Collections.emptyList();
        }
        List<DistrictDict> districtDicts = districtRepository.selectByParent(parentId);
        return PriceBeanUtils.copyProperty(districtDicts, DistrictListResponse.class);
    }

    @Override
    public Map<String, List<DistrictListResponse>> getDistrictByLevel(Integer level) {
        Map<String, List<DistrictListResponse>> pinyinToDistrictMap = redisService.getObject(RedisCacheKey.DISTRICT_CITY_ALL, Map.class);
        if (!CollectionUtils.isEmpty(pinyinToDistrictMap)) {
            return pinyinToDistrictMap;
        }

        // 获取该级所有的行政区划
        List<DistrictDict> districtDictList = districtRepository.selectByLevel(level);
        List<DistrictListResponse> districtListRespBOList = PriceBeanUtils.copyProperty(districtDictList, DistrictListResponse.class);

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
                .stream().sorted(Comparator.comparing(DistrictListResponse::getPinyin))
                .collect(Collectors.groupingBy(DistrictListResponse::getFirstLetter));
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
            districtDict.setCreateTime(LocalDateTime.now());
            districtDict.setUpdateTime(LocalDateTime.now());
            districtDict.setDeleted(false);
            districtRepository.addDistrict(districtDict);
            loopDistrict(jsonObject.getJSONArray("districts"), districtDict.getId());
        }
    }

}
