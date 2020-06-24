package com.aaa.yk.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/all")
        public List<Book> selectAllBooks() {
            return restTemplate.getForObject("http://book-interface/all", List.class);
        }
}
