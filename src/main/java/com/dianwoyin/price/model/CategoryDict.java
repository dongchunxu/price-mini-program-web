package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 类目定义表
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
