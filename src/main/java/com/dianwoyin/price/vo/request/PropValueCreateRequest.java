package com.dianwoyin.price.vo.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/6/23
 */
@Data
public class PropValueCreateRequest implements Serializable {

    private List<Prop> basicProps;

    private List<Prop> otherProps;

    @Data
    public static class Prop implements Serializable  {
        private Integer id;
        private Object value;
    }

}
