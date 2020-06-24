package com.aaa.yk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Param
 * @ClassName ApplicationRun7082
 * @Description TODO
 * @Author yk
 * @Date 2020/6/18 0018 15:34
 * @Return
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRun7082 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7082.class,args);
    }
}
