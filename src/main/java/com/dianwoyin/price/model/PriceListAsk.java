package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 价格单
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PriceListAsk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 报价名称
     */
    private String name;

    /**
     * 报价单内容
     */
    private String content;

    /**
     * 品类id
     */
    private Integer categoryId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建人
     */
    private Integer createdId;

    /**
     * 状态，1:进行中,2:已完成,3:已终止
     */
    private Integer status;

    /**
     * 是否删除，0：未删除，1：删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
