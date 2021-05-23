package com.dianwoyin.price.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 标签定义表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagDict {
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

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