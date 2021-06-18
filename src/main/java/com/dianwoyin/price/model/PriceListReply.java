package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 价格单回复
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PriceListReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 价格单id
     */
    private Integer priceListId;

    /**
     * 价格
     */
    private Integer amount;

    /**
     * 是否采纳
     */
    private Boolean chosen;

    /**
     * 交付时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建人id
     */
    private Integer createdId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除，0：未删除，1：删除
     */
    private Boolean deleted;


}
