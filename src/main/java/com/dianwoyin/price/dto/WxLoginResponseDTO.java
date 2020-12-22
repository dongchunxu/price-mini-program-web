package com.dianwoyin.price.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxLoginResponseDTO {
    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "session_key")
    private String sessionKey;

    @JSONField(name = "unionid")
    private String unionId;

    @JSONField(name = "errcode")
    private String errCode;

    @JSONField(name = "errmsg")
    private String errMsg;
}
