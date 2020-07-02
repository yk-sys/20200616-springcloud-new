package com.aaa.yk.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Param
 * @ClassName com.aaa.yk.springcloud.ApplicationRun8084
 * @Description TODO
 * @Author yk
 * @Date 2020/7/1 0001 19:35
 * @Return
 **/
@SpringBootApplication
@MapperScan("com.aaa.yk.springcloud.mapper")
@EnableCircuitBreaker
@EnableDiscoveryClient
public class ApplicationRun8084 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8084.class,args);
    }
}
