package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Data
@Builder
@ApiModel("账户返回对象")
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse implements Serializable {
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
}
