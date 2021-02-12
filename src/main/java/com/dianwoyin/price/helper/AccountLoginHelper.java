package com.dianwoyin.price.helper;

import com.dianwoyin.price.constants.RedisCacheKey;
import com.dianwoyin.price.dto.UserLogin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.dianwoyin.price.constants.RedisCacheKey.USER_LOGIN;

/**
 * @author chunxu.dong
 * @date 2020/12/19
 */
public class AccountLoginHelper {

    public static UserLogin getLogin() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        return (UserLogin) session.getAttribute(USER_LOGIN);
    }

    public static void setLogin(UserLogin userLogin) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(USER_LOGIN, userLogin);
    }

    public static String getLoginIp() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getRemoteAddr();
    }

    public static String sendLoginSmsCode() {
        String smsCode = "1234";
        HttpSession session = getSession();
        session.setAttribute(RedisCacheKey.LOGIN_SMS_CODE, smsCode);
        return "smsCode";
    }

    public static String getLoginSmsCode() {
        HttpSession session = getSession();
        Object smsCode = session.getAttribute(RedisCacheKey.LOGIN_SMS_CODE);
        return smsCode != null ? (String) smsCode: null;
    }

    private static HttpSession getSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        return session;
    }

    public static void logout() {
        HttpSession session = getSession();
        session.invalidate();
    }
}
