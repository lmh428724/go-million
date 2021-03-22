package com.sg.learn.gomillion;

import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoMillionApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoMillionApplication.class, args);
    }
}
