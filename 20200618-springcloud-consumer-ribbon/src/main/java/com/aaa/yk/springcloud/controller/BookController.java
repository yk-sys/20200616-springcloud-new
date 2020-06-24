package com.aaa.yk.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.List;

/**
 * @Param
 * @ClassName BookController
 * @Description TODO
 * @Author yk
 * @Date 2020/6/18 0018 15:37
 * @Return
 **/
@RestController
public class BookController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/all")
        public List<Book> selectAllBooks() {
            return restTemplate.getForObject("http://book-interface/all", List.class);
        }
        /**
         * @Description :
         *      因为ribbon在脱离了eureka之后，必须要使用真实的外网ip，也就是说没有公网ip是无法进行访问的
         *      花生壳(收费)，也有其他的开源工具--->外网穿透
         *      打开这个软件之后会有一个公网的ip地址
         * @return : java.util.List<java.awt.print.Book>
         * @author : yk
         * @date : 2020/06/24 15:30
         */
    @GetMapping("/allNoEureka")
    public List<Book> selectAllBooksNoEureka(){
        /*1.通过application.properties文件中配置的算法规则来进行选择最终的具体的某一台provider
        * serviceId就是在application.properties中配置的spring.application的值*/
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-interface");
        /*2.获取最终通过负载均衡算法所获取的server的ip地址以及server的端口号*/
        String host = serviceInstance.getHost();//localhost
        System.out.println(host);
        int port = serviceInstance.getPort();//8081,8082,8083
        System.out.println(port);
        /*3.调用restTemplate来进行发送请求
        * http://localhost:8081,8082,8083/all*/
        return restTemplate.getForObject("http://"+host+":"+port+"/all", List.class);
    }
}
