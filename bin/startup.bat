@echo off
echo starting application
::################################
::应用端口配置
set SERVER_PORT=100000
::################################
:: 待浏览的文章
set ARTICLE_URL_ONE=https://blog.csdn.net/weixin_45884459/article/details/113105659
set ARTICLE_URL_TWO=https://blog.csdn.net/weixin_45884459/article/details/108132492
set ARTICLE_URL_THREE=https://blog.csdn.net/weixin_45884459/article/details/111044525
set ARTICLE_URL_FOUR=https://blog.csdn.net/weixin_45884459/article/details/108831372
set ARTICLE_URL_FIVE=https://blog.csdn.net/weixin_45884459/article/details/106856984
set ARTICLE_URL_SIX=https://blog.csdn.net/weixin_45884459/article/details/109677861
set ARTICLE_URL_SEVEN=https://blog.csdn.net/weixin_45884459/article/details/113851090
set ARTICLE_URL_EIGHT=https://blog.csdn.net/weixin_45884459/article/details/106931236
set ARTICLE_URL_NINE=https://blog.csdn.net/weixin_45884459/article/details/109380252
set ARTICLE_URL_TEN=https://blog.csdn.net/weixin_45884459/article/details/111508104
::################################
:: 浏览频率
set CRON_HTTPREQUEST=0/6 * * * * *
::################################
:: 数据库配置
set MYSQL_IP=127.0.0.1
set MYSQL_PORT=3306
set MYSQL_DB=go_million
set MYSQL_USER=root
set MYSQL_PWD=root
::################################
:: 日志路径
set LOG_PATH=E:/log/go-million

set appName=go-million-0.0.1-SNAPSHOT
set appJar=%appName%.jar
java -jar %appJar% >./%appName%.log
echo %appName% start success!

