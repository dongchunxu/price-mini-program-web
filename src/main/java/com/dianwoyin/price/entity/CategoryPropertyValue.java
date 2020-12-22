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
 * 类目属性值定义表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPropertyValue {
    private Integer id;

    /**
     * 属性id
     */
    private Integer propertyId;

    /**
     * 属性值名称
     */
    private String propertyValueName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除，0：未删除，1：已删除
     */
    private Boolean deleted;
}