package com.aaa.yk.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Param
 * @ClassName ApplicationRun8081
 * @Description TODO
 * @Author yk
 * @Date 2020/6/24 0024 10:22
 * @Return
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aaa.yk.springcloud.mapper")
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class,args);
    }
}

