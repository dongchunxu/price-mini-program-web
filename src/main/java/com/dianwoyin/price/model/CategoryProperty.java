package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 类目属性定义表
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
