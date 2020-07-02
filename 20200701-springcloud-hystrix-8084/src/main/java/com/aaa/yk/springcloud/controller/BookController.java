package com.aaa.yk.springcloud.controller;

import com.aaa.yk.springcloud.model.Book;
import com.aaa.yk.springcloud.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Param
 * @ClassName BookController
 * @Description TODO
 * @Author yk
 * @Date 2020/7/1 0001 19:38
 * @Return
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    /**
     * @Description :
        查询所有图书信息
            可以给selectAllBooks方法提供一个备用方法，这个备用方法一定是无论什么时候都可正常运行的
            所以该方法的一个必要条件就是不能查询数据库

            这种写法的弊端：
                如果在实际开发中，一个实体类对应就是一个controller，也就是一张表对应的就是一个controller
                导致备用方法会出现在每一个controller中，不方便去维护

            ！！在开发阶段，不允许上熔断
     * @return : java.util.List<com.aaa.yk.springcloud.model.Book>
     * @author : yk
     * @date : 2020/07/01 19:40
     */
    @GetMapping("/all")
    //@HystrixCommand(fallbackMethod = "selectAllBooksFallBack")
    public List<Book> selectAllBooks() throws Exception {

        List<Book> bookList = bookService.selectAllBooks();
        if (bookList.size()>0){
            //抛异常
            throw new Exception("模拟异常");
        }
        return bookList;
    }

    /**
     * @Description :
            备用方法，模拟的，真实的写法是直接返回一个字符串即可
     * @return : java.util.List<com.aaa.yk.springcloud.model.Book>
     * @author : yk
     * @date : 2020/07/01 19:59
     */
   /* public List<Book> selectAllBooksFallBack(){
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book().setId(10000L).setBookName("测试备用方法").setBookPrice(18.8);
        bookList.add(book);
        return bookList;
    }*/
}
