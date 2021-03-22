@echo off
echo starting application
::################################
::应用端口配置
set SERVER_PORT=100000
::################################
:: 待浏览的文章
set ARTICLE_URL_ONE=https://blog.csdn.net/weixin_45884459/article/details/114931331
set ARTICLE_URL_TWO=https://blog.csdn.net/weixin_45884459/article/details/114930439
set ARTICLE_URL_THREE=https://blog.csdn.net/weixin_45884459/article/details/114921852
set ARTICLE_URL_FOUR=https://blog.csdn.net/weixin_45884459/article/details/114921571
set ARTICLE_URL_FIVE=https://blog.csdn.net/weixin_45884459/article/details/114025406
set ARTICLE_URL_SIX=https://blog.csdn.net/weixin_45884459/article/details/113887113
set ARTICLE_URL_SEVEN=https://blog.csdn.net/weixin_45884459/article/details/112275198
set ARTICLE_URL_EIGHT=https://blog.csdn.net/weixin_45884459/article/details/111590698
set ARTICLE_URL_NINE=https://blog.csdn.net/weixin_45884459/article/details/109384150
set ARTICLE_URL_TEN=https://blog.csdn.net/weixin_45884459/article/details/106840974
::################################
:: 浏览频率
set CRON_HTTPREQUEST=0/3 * * * * *
::################################
:: 日志路径
set LOG_PATH=E:/log/go-million



set appName=go-million-0.0.1-SNAPSHOT
set appJar=%appName%.jar
java -jar %appJar% >./%appName%.log
echo %appName% start success!

