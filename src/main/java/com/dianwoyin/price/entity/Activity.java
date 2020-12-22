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
    * 活动表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private Integer id;

    /**
    * 是否删除，0：未删除，1：已删除
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