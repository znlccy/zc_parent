package com.znlccy.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-19:47
 * @remark: 启动类
 */
@SpringBootApplication
public class RecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class,args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }
}
