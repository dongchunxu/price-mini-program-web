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
 * 类目属性定义表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProperty {
    private Integer id;

    /**
     * 属性名
     */
    private String propertyName;

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 空间类型: 0：下拉，1：输入，2：单选，3：多选
     */
    private Integer inputType;

    /**
     * 是否必填，0:必填，1：非必填
     */
    private Boolean must;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 是否删除，0：未删除，1：删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}