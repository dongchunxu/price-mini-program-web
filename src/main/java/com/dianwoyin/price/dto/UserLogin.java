package com.dianwoyin.price.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserLogin implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;


    /**
     * 腾讯openid
     */
    private String openId;

    /**
     *
     */
    private String phone;

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    /**
     *
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别，0：男，1：女
     */
    private Integer sex;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次登录ip
     */
    private String lastLoginIp;

    /**
     * 邀请码
     */
    private String inviteCode;
}
