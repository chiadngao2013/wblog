package com.example.wblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.wblog.mapper")
@EnableScheduling//开启定时任务支持
public class WblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WblogApplication.class, args);
    }

}
