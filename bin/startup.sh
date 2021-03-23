#!/bin/bash
echo starting application
#################################
# 应用端口配置
export SERVER_PORT=100000
#################################
# 待浏览的文章
export ARTICLE_URL_ONE=https://blog.csdn.net/weixin_45884459/article/details/113105659
export ARTICLE_URL_TWO=https://blog.csdn.net/weixin_45884459/article/details/108132492
export ARTICLE_URL_THREE=https://blog.csdn.net/weixin_45884459/article/details/111044525
export ARTICLE_URL_FOUR=https://blog.csdn.net/weixin_45884459/article/details/108831372
export ARTICLE_URL_FIVE=https://blog.csdn.net/weixin_45884459/article/details/106856984
export ARTICLE_URL_SIX=https://blog.csdn.net/weixin_45884459/article/details/109677861
export ARTICLE_URL_SEVEN=https://blog.csdn.net/weixin_45884459/article/details/113851090
export ARTICLE_URL_EIGHT=https://blog.csdn.net/weixin_45884459/article/details/106931236
export ARTICLE_URL_NINE=https://blog.csdn.net/weixin_45884459/article/details/109380252
export ARTICLE_URL_TEN=https://blog.csdn.net/weixin_45884459/article/details/111508104
#################################
# 浏览频率
export CRON_HTTPREQUEST=0/6 * * * * *
#################################
# 数据库配置
export MYSQL_IP=127.0.0.1
export MYSQL_PORT=3306
export MYSQL_DB=go_million
export MYSQL_USER=root
export MYSQL_PWD=root
#################################
# 日志路径
export LOG_PATH=/home/apps/go-million/logs


appName=go-million-0.0.1-SNAPSHOT
appJar=$appName".jar"
nohup java -jar $appJar >./$appName".log" 2>&1 &
echo $! > $appName".tpid"
echo $appName start success!

