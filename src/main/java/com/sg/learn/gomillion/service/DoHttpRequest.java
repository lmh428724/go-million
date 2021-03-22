package com.sg.learn.gomillion.service;

import cn.hutool.http.HttpUtil;
import com.sg.learn.gomillion.entity.AritcleUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
//@RequiredArgsConstructor
public class DoHttpRequest{

    @Autowired
    private AritcleUrl aritcleUrl;

    public void doHttpRequest(){
        String content = HttpUtil.get(aritcleUrl.get());
        String title = this.getTitle(content);
        log.info("阅读了文章:{}",title);
        String readCount = this.getReadCount(content);
        log.info("该文章的当前阅读量为:{}",readCount);
    }

    /**
     * 处理网页内容获取当前阅览量
     * @param content
     * @return
     */
    private String getReadCount(String content){
        //  <span class="read-count">1040</span>
        int start = content.indexOf("read-count")+12;
        int end = content.indexOf("span",start)-2;
        return content.substring(start,end);
    }

    /**
     * 处理网页内容获取当前文章的标题
     * @param content
     * @return
     */
    private String getTitle(String content){
        // <title>SuSE 12 linux 开发环境搭建 之 redis安装与自启设置_学习使我快乐-CSDN博客</title>
        int start = content.indexOf("title")+6;
        int end = content.indexOf("title",start)-2;
        return content.substring(start,end);
    }
}
