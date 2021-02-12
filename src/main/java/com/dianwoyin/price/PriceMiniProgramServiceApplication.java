package com.dianwoyin.price;

import com.dianwoyin.price.vo.response.PropResponse;
import com.dianwoyin.price.vo.response.PropValueResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
@MapperScan("com.dianwoyin.price.mapper")
public class PriceMiniProgramServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceMiniProgramServiceApplication.class, args);
    }


}
