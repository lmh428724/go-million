package com.sg.learn.gomillion;

import cn.hutool.http.HttpUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( basePackages = "com.sg.learn.gomillion.article.mapper")
public class GoMillionApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoMillionApplication.class, args);
    }
}
