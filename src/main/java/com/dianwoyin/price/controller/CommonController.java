package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.QcloudFileService;
import com.dianwoyin.price.vo.ResponseBaseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author chunxu.dong
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private QcloudFileService qcloudFileService;

    @PostMapping("/uploadImg")
    @ApiOperation("上传图片")
    public ResponseBaseVO<Boolean> uploadImg(@RequestParam("file") @NotNull MultipartFile file) {
        try {
            return ResponseBaseVO.ok(qcloudFileService.uploadImg(file) != null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
