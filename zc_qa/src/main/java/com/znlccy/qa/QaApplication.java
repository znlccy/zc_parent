package com.znlccy.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-10-03-18:44
 * @remark: 问答启动类
 */
@SpringBootApplication
public class QaApplication {

    /**
     * 启动主类
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
    }

    /**
     * 雪花算法
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
