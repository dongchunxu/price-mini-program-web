package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.dto.LocationDTO;
import com.dianwoyin.price.service.LocationRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chunxu.dong
 * @date 2021/6/3
 */
@Slf4j
@Service
public class LocationRemoteServiceImpl implements LocationRemoteService {

    @Override
    public LocationDTO getLocation(String lng, String lat) {
        return LocationDTO.builder()
                .province("江苏省")
                .city("扬州市")
                .district("邗江区")
                .build();
    }
}
