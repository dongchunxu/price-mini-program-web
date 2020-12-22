package com.dianwoyin.price.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */

/**
 * 行政区域定义表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDict {
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private String cityCode;

    private String adCode;

    /**
     * 名称
     */
    private String name;

    private Integer level;

    /**
     * 是否删除，0：未删除，1：删除
     */
    private Boolean deleted;

    private Integer parentId;
}