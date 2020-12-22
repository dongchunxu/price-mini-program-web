package com.dianwoyin.price.interceptor;

import com.dianwoyin.price.constants.RedisCacheKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Component
@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HttpSession session = request.getSession();

        return session.getAttribute(RedisCacheKey.USER_LOGIN_INFO) != null;
    }
}
