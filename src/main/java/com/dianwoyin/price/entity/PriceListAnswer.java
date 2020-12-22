package com.dianwoyin.price.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
/**
    * 报价单表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceListAnswer {
    private Integer id;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;
}