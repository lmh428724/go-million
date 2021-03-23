package com.sg.learn.gomillion.job;

import com.sg.learn.gomillion.article.service.impl.ArticleReadServiceImpl;
import com.sg.learn.gomillion.article.service.impl.ArticleServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class DoHttpRequestJob {

    private final ArticleServiceImpl articleService;

    @Scheduled(cron = "${cronStr.doHttpRequest}")
    public void doHttpRequestJob(){
        log.info("####################################################");
        log.info("开始执行定时任务");
        articleService.readArticle();
        log.info("定时任务执行完毕");
    }

}
