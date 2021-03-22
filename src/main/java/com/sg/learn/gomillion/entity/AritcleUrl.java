package com.sg.learn.gomillion.entity;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class AritcleUrl {
    @Value("${article.urls.one}")
    private String url1;
    @Value("${article.urls.two}")
    private String url2;
    @Value("${article.urls.three}")
    private String url3;
    @Value("${article.urls.four}")
    private String url4;
    @Value("${article.urls.five}")
    private String url5;
    @Value("${article.urls.six}")
    private String url6;
    @Value("${article.urls.seven}")
    private String url7;
    @Value("${article.urls.eight}")
    private String url8;
    @Value("${article.urls.nine}")
    private String url9;
    @Value("${article.urls.ten}")
    private String url10;
    public String get() {
        String[] urls = {url1, url2, url3, url4, url5, url6, url7, url8, url9, url10};
        //运用hutools产生一个[0,10)的随机整数
        int anInt = RandomUtil.randomInt(0, 10);
        log.info("获取到指针:{}", anInt);
        return urls[anInt];
    }
}
