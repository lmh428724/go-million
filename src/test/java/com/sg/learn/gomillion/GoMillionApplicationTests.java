package com.sg.learn.gomillion;

import com.sg.learn.gomillion.service.DoHttpRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RequiredArgsConstructor
class GoMillionApplicationTests {

    @Autowired
    private DoHttpRequest doHttpRequest;

    @Test
    void contextLoads() {
        doHttpRequest.doHttpRequest();
    }

}
