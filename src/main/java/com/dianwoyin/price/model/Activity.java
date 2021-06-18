package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动名称
     */
    private String activityName;

    private String imgUrls;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 最大参加人数
     */
    private Integer maxJoinNum;

    /**
     * 当前参与人数
     */
    private Integer currentJoinNum;

    /**
     * 活动开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 活动结束时间
     */
    private LocalDateTime endTime;

    /**
     * 是否删除，0：未删除，1：已删除
     */
    private Boolean deleted;

    /**
     * 发布人
     */
    private Integer createId;

    /**
     * 创建人名
     */
    private String createName;

    /**
     * 更新人id
     */
    private Integer updateId;

    /**
     * 更新人名
     */
    private String updateName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
