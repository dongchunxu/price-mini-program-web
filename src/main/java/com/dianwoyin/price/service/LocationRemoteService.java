package com.dianwoyin.price.service;

import com.dianwoyin.price.dto.LocationDTO;

/**
 * @author chunxu.dong
 * @date 2021/6/3
 */
public interface LocationRemoteService {

    LocationDTO getLocation(String lng, String lat);
}
