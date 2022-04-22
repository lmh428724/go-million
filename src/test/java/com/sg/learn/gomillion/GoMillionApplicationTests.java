package com.sg.learn.gomillion;

import cn.hutool.http.HttpUtil;
import com.sg.learn.gomillion.article.service.impl.ArticleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RequiredArgsConstructor
class GoMillionApplicationTests {

    @Autowired
    private ArticleServiceImpl articleService;
   
    @Test
    void contextLoads() {
       // articleService.readArticle();
    }

}
