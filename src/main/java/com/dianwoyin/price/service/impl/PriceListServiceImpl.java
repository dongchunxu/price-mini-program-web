package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.constants.enums.PriceListStatusEnum;
import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.price.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
        // mock 空数据
        if (priceListStatus == 2) {
            return PageResult.of(Collections.emptyList(), page, pageSize, 0);
        }

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
        GoodsDetail goodsDetail = new GoodsDetail();
        List<SimplePropPair> props = new ArrayList<>();
        props.add(new SimplePropPair("材料", "尼龙"));
        props.add(new SimplePropPair("尺寸", "10&12正开"));
        props.add(new SimplePropPair("数量", "1000"));
        props.add(new SimplePropPair("印面", "单面"));
        props.add(new SimplePropPair("工艺", "双面亮膜"));
        goodsDetail.setPropValues(props);
        goodsDetail.setComment("今天一定要送到哦！");

        DeliveryDetail deliveryDetail = new DeliveryDetail();
        deliveryDetail.setDeliveryChannel(0);
        deliveryDetail.setReceiverAddressDetail("3栋2单元");
        deliveryDetail.setReceiverAddress("江苏省扬州市汉江中路101号");
        deliveryDetail.setExpectDeliveryTime(new Date());

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo("xx-sss-12312313");
        orderDetail.setOrderCreateTime(new Date());
        orderDetail.setPayChannel(1);

        List<PriceListReplyDetail> priceListReplyList = new ArrayList<>();
        PriceListReplyDetail detail = new PriceListReplyDetail();
        detail.setAmount(BigDecimal.TEN);
        detail.setComment("你好");
        detail.setSupplierName("华东彩印");
        detail.setCreateTime(new Date());
        detail.setSupplierAvatar("https://t7.baidu.com/it/u=1831997705,836992814&fm=193&f=GIF");
        detail.setDeliveryTime(new Date());
        priceListReplyList.add(detail);

        return PriceListDetailResponse.builder()
                .priceListId(123)
                .priceListStatus(PriceListStatusEnum.Going.getCode())
                .goodsName("标准不干胶100张")
                .goodsImgUrl("")
                .goodsDetail(goodsDetail)
                .deliveryDetail(deliveryDetail)
                .payAmount(BigDecimal.valueOf(12313,2))
                .goodsDetail(goodsDetail)
                .orderDetail(orderDetail)
                .priceListReplyList(priceListReplyList)
                .createTime(new Date())
                .build();
    }

    @Override
    public Boolean confirmPrice(Integer priceListId, Integer priceListReplyId, String operator) {
        return true;
    }
}
