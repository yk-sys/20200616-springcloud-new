package com.aaa.yk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Param
 * @ClassName ApplicationRun4081
 * @Description TODO
 * @Author yk
 * @Date 2020/7/2 0002 17:52
 * @Return
 **/
@SpringBootApplication
@EnableConfigServer
public class ApplicationRun4081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun4081.class,args);
    }
}
