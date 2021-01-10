package com.imooc;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yaojun
 * @create 2021-01-08 07:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogTest {
    private final Logger logger = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLog(){
        String name = "imooc";
        String password = "123456";
//        log.debug("debug...");
//        log.info("debug...");
//        log.error("error...");
        logger.info("name:{}, password:{}", name, password);
    }

    @Test
    public void testSlf4j(){
        log.debug("debug...");
        log.info("debug...");
        log.error("error...");
    }
}
