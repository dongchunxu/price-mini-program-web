package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RestController
public class TestController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request) {

        // 测试session的类型
        HttpSession session = request.getSession();
        System.out.println(session);
//        districtService.init();
        return "ok";
    }
}
