package com.dianwoyin.price.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/19
 */

/**
 * 类目定义表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDict {
    private Integer id;

    /**
     * 类目名
     */
    private String categoryName;

    /**
     * 父类目id
     */
    private Integer parentId;

    /**
     * 图片url
     */
    private String imgUrl;

    /**
     * 是否是叶子节点，0：非叶子，1：叶子
     */
    private Boolean leaf;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 是否删除，0:未删除,1:删除
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