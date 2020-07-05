package com.zjut.azhen.DBDesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.zjut.azhen.ncov.mapping")
@SpringBootApplication
@EnableCaching
public class NcovApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcovApplication.class, args);
    }

}
