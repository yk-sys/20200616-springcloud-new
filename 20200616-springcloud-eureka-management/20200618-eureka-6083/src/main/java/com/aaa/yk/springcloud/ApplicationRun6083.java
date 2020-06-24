package com.aaa.yk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Param
 * @ClassName ApplicationRun6083
 * @Description TODO
 * @Author yk
 * @Date 2020/6/18 0018 15:14
 * @Return
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun6083 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6083.class,args);
    }
}
