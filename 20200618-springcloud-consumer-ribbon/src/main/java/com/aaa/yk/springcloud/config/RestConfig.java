package com.aaa.yk.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Param
 * @ClassName RestConfig
 * @Description TODO
 * @Author yk
 * @Date 2020/6/18 0018 15:35
 * @Return
 **/
@Configuration
public class RestConfig {
    @Bean
    /*@LoadBalanced*/
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

   /* @Bean
    public IRule mineRule(){
        return new RandomRule();
    }*/
}
