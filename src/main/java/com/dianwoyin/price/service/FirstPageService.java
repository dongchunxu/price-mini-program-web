package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.response.firstpage.FirstPageResponse;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
public interface FirstPageService {

    /**
     * @return
     */
    FirstPageResponse getFirstPage(Integer cityId);
}
