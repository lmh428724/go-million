#!/bin/bash
echo starting application
#################################
# 应用端口配置
export SERVER_PORT=100000
#################################
# 待浏览的文章
export ARTICLE_URL_ONE=https://blog.csdn.net/weixin_45884459/article/details/114931331
export ARTICLE_URL_TWO=https://blog.csdn.net/weixin_45884459/article/details/114930439
export ARTICLE_URL_THREE=https://blog.csdn.net/weixin_45884459/article/details/114921852
export ARTICLE_URL_FOUR=https://blog.csdn.net/weixin_45884459/article/details/114921571
export ARTICLE_URL_FIVE=https://blog.csdn.net/weixin_45884459/article/details/114025406
export ARTICLE_URL_SIX=https://blog.csdn.net/weixin_45884459/article/details/113887113
export ARTICLE_URL_SEVEN=https://blog.csdn.net/weixin_45884459/article/details/112275198
export ARTICLE_URL_EIGHT=https://blog.csdn.net/weixin_45884459/article/details/111590698
export ARTICLE_URL_NINE=https://blog.csdn.net/weixin_45884459/article/details/109384150
export ARTICLE_URL_TEN=https://blog.csdn.net/weixin_45884459/article/details/106840974
#################################
# 浏览频率
export CRON_HTTPREQUEST=0/3 * * * * *
#################################
# 日志路径
export LOG_PATH=/home/apps/go-million/logs


appName=go-million-0.0.1-SNAPSHOT
appJar=$appName".jar"
nohup java -jar $appJar >./$appName".log" 2>&1 &
echo $! > $appName".tpid"
echo $appName start success!

