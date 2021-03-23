package com.sg.learn.gomillion.tools;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.generator.SnowflakeGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class IdGenerator {
    @Value("${snowflake.dataCenterId}")
    private long dataCenterId;
    @Value("${snowflake.workerId}")
    private long workerId;

    private Snowflake snowflake;

    public long nextId(){
        return snowflake.nextId();
    }

    public String nextIdStr(){
        return snowflake.nextIdStr();
    }

    @PostConstruct
    public void init(){
        if(snowflake==null){
            snowflake = new Snowflake(workerId, dataCenterId);
        }
    }
}
