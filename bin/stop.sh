#!/bin/bash
appName=go-million-0.0.1-SNAPSHOT
tpid=`ps -ef|grep $appName|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'Stopping' $appName '...'
    kill -15 $tpid
fi
sleep 5
tpid=`ps -ef|grep $appName|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'Kill' $appName 'Process!'
    kill -9 $tpid
else
    echo $appName 'Stoped Success!'
fi
