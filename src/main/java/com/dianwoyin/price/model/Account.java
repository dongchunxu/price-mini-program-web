package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 腾讯openid
     */
    private String openId;

    private String phone;

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别，0：男，1：女
     */
    private Boolean sex;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 上次登录ip
     */
    private String lastLoginIp;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除，0：未删除，1：已删除
     */
    private Boolean deleted;


}
