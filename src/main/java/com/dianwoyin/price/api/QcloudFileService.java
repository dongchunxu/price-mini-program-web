package com.dianwoyin.price.api;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author chunxu.dong
 * @date 2020/12/22
 */
public interface QcloudFileService {

    /**
     * 上传
     * @param file
     * @return
     */
    Boolean upload(MultipartFile file) throws IOException;
}
