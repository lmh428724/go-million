package com.sg.learn.gomillion.article.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.generator.SnowflakeGenerator;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sg.learn.gomillion.article.entity.AritcleUrl;
import com.sg.learn.gomillion.article.entity.Article;
import com.sg.learn.gomillion.article.entity.ArticleRead;
import com.sg.learn.gomillion.article.mapper.ArticleMapper;
import com.sg.learn.gomillion.article.mapper.ArticleReadMapper;
import com.sg.learn.gomillion.article.service.IArticleReadService;
import com.sg.learn.gomillion.article.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sg.learn.gomillion.tools.IdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author healy
 * @since 2021-03-22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    private final AritcleUrl aritcleUrl;

    private final IArticleReadService articleReadService;

    private final IdGenerator idGenerator;


    public void readArticle() {

        //阅读文章
        String content = HttpUtil.get(aritcleUrl.get());

        //获取文章的序号,标题,阅读量
        String id = this.getArticleId(content);
        String title = this.getTitle(content);
        String readCount = this.getReadCount(content);
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setReadCount(readCount);
        log.info("阅读了{}文章:{},该文章的当前阅读量为:{}", id, title, readCount);
        //校验表单中有无该数据,有则修改,无则添加
        if (this.getById(id) == null) {
            this.save(article);
        } else {
            this.updateById(article);
        }
        QueryWrapper<ArticleRead> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id",id);
        queryWrapper.ge("create_time", DateUtil.beginOfDay(new Date()));
        queryWrapper.le("create_time", DateUtil.endOfDay(new Date()));
        //若当日不存在该文章的数据
        ArticleRead result = articleReadService.getOne(queryWrapper);
        if (result == null){
            result = new ArticleRead();
            result.setId(String.valueOf(idGenerator.nextId()));
            result.setArticleId(id);
            result.setOriginalCount(readCount);
            result.setFinalCount(readCount);
            result.setReadAdd("0");
            articleReadService.save(result);
        } else { //若当日已存在该文章
            int originalCount = Integer.parseInt(result.getOriginalCount());
            int finalCount = Integer.parseInt(readCount);
            int readAdd = finalCount-originalCount;
            result.setReadAdd(String.valueOf(readAdd));
            result.setCreateTime(null);
            result.setUpdateTime(null);
            result.setFinalCount(String.valueOf(finalCount));
            articleReadService.updateById(result);
        }
    }

    /**
     * 获取文章序号
     *
     * @param content
     * @return
     */
    private String getArticleId(String content) {
        //var articleId = 114931331;
        int start = content.indexOf("articleId") + 12;
        int end = content.indexOf(";", start);
        return content.substring(start, end);
    }

    /**
     * 处理网页内容获取当前文章的标题
     *
     * @param content
     * @return
     */
    private String getTitle(String content) {
        // <title>SuSE 12 linux 开发环境搭建 之 redis安装与自启设置_学习使我快乐-CSDN博客</title>
        int start = content.indexOf("<title>") + 7;
        int end = content.indexOf("</title>", start);
        return content.substring(start, end);
    }

    /**
     * 处理网页内容获取当前阅览量
     *
     * @param content
     * @return
     */
    private String getReadCount(String content) {
        //  <span class="read-count">1040</span>
        int start = content.indexOf("read-count") + 12;
        int end = content.indexOf("span", start) - 2;
        return content.substring(start, end);
    }

}
