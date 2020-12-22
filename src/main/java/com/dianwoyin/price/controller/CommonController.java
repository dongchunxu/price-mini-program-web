package com.dianwoyin.price.controller;

import com.dianwoyin.price.vo.ResponseBaseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chunxu.dong
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @PostMapping("/uploadImg")
    @ApiOperation("上传图片")
    public ResponseBaseVO<Boolean> uploadImg(@RequestParam("file") MultipartFile file) {
        return ResponseBaseVO.ok(true);
    }

}
