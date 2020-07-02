package com.aaa.yk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Param
 * @ClassName TestController
 * @Description TODO
 * @Author yk
 * @Date 2020/7/2 0002 15:55
 * @Return
 **/
@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @GetMapping("/test")
    public String test() {
        return port+":"+driverClassName;
    }
}
