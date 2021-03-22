package com.sg.learn.gomillion.job;

import cn.hutool.http.HttpUtil;
import com.sg.learn.gomillion.entity.AritcleUrl;
import com.sg.learn.gomillion.service.DoHttpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class DoHttpRequestJob {

    private final DoHttpRequest doHttpRequest;

    @Scheduled(cron = "${cronStr.doHttpRequest}")
    public void doHttpRequestJob(){
        log.info("####################################################");
        log.info("开始执行定时任务");
        doHttpRequest.doHttpRequest();
        log.info("定时任务执行完毕");
    }

}
