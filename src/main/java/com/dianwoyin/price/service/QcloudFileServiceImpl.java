package com.dianwoyin.price.service;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.api.QcloudFileService;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author chunxu.dong
 * @date 2020/12/22
 */
@Service
@Slf4j
public class QcloudFileServiceImpl implements QcloudFileService {

    private COSClient cosClient;

    @Value("${qcloud.bucket-name}")
    private String bucketName;
    @Value("${qcloud.secret-id}")
    private String secretId;
    @Value("${qcloud.secret-key}")
    private String secretKey;
    @Value("${qcloud.region}")
    private String regionName;

    @PostConstruct
    public void init() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(regionName);
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
    }

    @Override
    public String uploadImg(MultipartFile multipartFile) throws IOException {
        if (multipartFile == null || multipartFile.getOriginalFilename() == null) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_IMG_UPLOAD);
        }
        File localFile = new File(multipartFile.getOriginalFilename());
        try {
            String oldName = multipartFile.getOriginalFilename();
            int idx = oldName.lastIndexOf(".");
            if (idx == -1) {
                throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_IMG_UPLOAD);
            }
            String newName = oldName.substring(0, idx) + "-" + System.currentTimeMillis() + oldName.substring(idx);
            // 指定要上传的文件
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), localFile);
            // 指定要上传到的存储桶
            // 指定要上传到 COS 上对象键
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, newName, localFile);
            cosClient.putObject(putObjectRequest);
            return newName;
        } catch (Exception e) {
            log.error("upload file error", e);
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_IMG_UPLOAD);
        } finally {
          try { localFile.delete(); } catch (Exception ignored){}
        }
    }

}
