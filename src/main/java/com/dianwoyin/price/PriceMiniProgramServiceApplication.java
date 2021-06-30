package com.dianwoyin.price;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.dianwoyin.price.mapper")
@EnableConfigurationProperties
public class PriceMiniProgramServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceMiniProgramServiceApplication.class, args);
    }


}
