package com.sg.learn.gomillion;

import cn.hutool.http.HttpUtil;

public class Test {
    public static void main(String[] args) {
        System.out.println();
        //String content = HttpUtil.get("https://blog.csdn.net/weixin_45884459/article/details/106931236");
        String content = HttpUtil.get("https://blog.csdn.net/weixin_45884459?spm=1011.2124.3001.5343&type=blog");
        System.out.println(content);
        System.out.println(getArticleId(content));
        System.err.println(getTitle(content));
        System.err.println(getReadCount(content));
    }
    /**
     * 获取文章序号
     *
     * @param content
     * @return
     */
    private static String getArticleId(String content) {
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
    private static String getTitle(String content) {
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
    private static String getReadCount(String content) {
        //  <span class="read-count">1040</span>
        int start = content.indexOf("read-count") + 12;
        int end = content.indexOf("span", start) - 2;
        return content.substring(start, end);
    }
}
