package com.example.wblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.wblog.mapper")
public class WblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WblogApplication.class, args);
    }

}
