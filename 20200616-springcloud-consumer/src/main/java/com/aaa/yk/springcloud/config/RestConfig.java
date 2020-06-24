package com.aaa.yk.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Param
 * @ClassName RestConfig
 * @Description TODO
 * @Author yk
 * @Date 2020/6/16 0016 16:27
 * @Return
 **/
@Configuration
public class RestConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
