package com.allfirst.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//使用MapperScan批量扫描所有的Mapper接口
@MapperScan(value = "com.allfirst.common.dao")
@SpringBootApplication
@EnableCaching//开启基于缓存的注解，开发中使用缓存中间件；redis、memcached、ehcache；
@EnableRabbit  //开启基于注解的RabbitMQ模式
@EnableAsync  //开启异步任务注解功能
@EnableScheduling //开启基于注解的定时任务
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}
