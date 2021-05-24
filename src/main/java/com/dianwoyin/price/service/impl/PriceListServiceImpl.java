package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.price.PriceListDetailResponse;
import com.dianwoyin.price.vo.response.price.PriceListListItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Service
public class PriceListServiceImpl implements PriceListService {

    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @Autowired
    private PriceListAskMapper priceListAskMapper;

    @Override
    public Boolean createPriceList(PriceListCreateRequest request) {
        return true;
    }

    @Override
    public PageResult<PriceListListItemResponse> getPriceListList(Integer priceListStatus, Integer page, Integer pageSize) {
        Integer total = 2;

        List<PriceListListItemResponse> dataList = new ArrayList<>();

        List<String> avatarList = new ArrayList<>();
        avatarList.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdimg.52bjw.cn%2Fimage%2Fupload%2Fcb%2F6a%2F13%2Fb3%2Fcb6a13b3fa90bdb998dbe693b3ad8846.jpg&refer=http%3A%2F%2Fdimg.52bjw.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624438821&t=81313fd79de1267c6fadc5812ca2a955");
        
        PriceListListItemResponse c1 = new PriceListListItemResponse();
        c1.setPriceListId(1);
        c1.setCreateTime(new Date());
        c1.setGoodsImgUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdimg.52bjw.cn%2Fimage%2Fupload%2Fcb%2F6a%2F13%2Fb3%2Fcb6a13b3fa90bdb998dbe693b3ad8846.jpg&refer=http%3A%2F%2Fdimg.52bjw.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624438821&t=81313fd79de1267c6fadc5812ca2a955");
        c1.setPriceListStatus(priceListStatus);
        c1.setPayAmount(BigDecimal.valueOf(12,2));
        c1.setGoodsName("不干胶cccc");
        c1.setSupplierAvatars(avatarList);
        dataList.add(c1);

        PriceListListItemResponse c2 = new PriceListListItemResponse();
        c2.setPriceListId(2);
        c2.setCreateTime(new Date());
        c2.setGoodsImgUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdimg.52bjw.cn%2Fimage%2Fupload%2Fcb%2F6a%2F13%2Fb3%2Fcb6a13b3fa90bdb998dbe693b3ad8846.jpg&refer=http%3A%2F%2Fdimg.52bjw.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624438821&t=81313fd79de1267c6fadc5812ca2a955");
        c2.setPriceListStatus(priceListStatus);
        c2.setPayAmount(BigDecimal.valueOf(12,2));
        c2.setGoodsName("不干胶cccc22222");
        dataList.add(c2);
        return PageResult.of(dataList, page, pageSize, total);
    }

    @Override
    public PriceListDetailResponse getPriceListDetail(Integer priceListId) {
        return null;
    }

    @Override
    public Boolean confirmPrice(Integer priceListId, Integer priceListReplyId, String operator) {
        return true;
    }
}
