package com.zjut.azhen.DBDesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author asus
 */
@MapperScan("com.zjut.azhen.DBDesign")
@SpringBootApplication
@EnableCaching
public class DBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBApplication.class, args);
    }

}
