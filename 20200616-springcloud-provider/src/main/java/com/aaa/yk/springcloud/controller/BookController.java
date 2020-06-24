package com.aaa.yk.springcloud.controller;

import com.aaa.yk.springcloud.model.Book;
import com.aaa.yk.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Param
 * @ClassName BookController
 * @Description TODO
 * @Author yk
 * @Date 2020/6/16 0016 16:18
 * @Return
 **/
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all", produces="application/json")
    public List<Book> allBooks(){
        System.out.println("8081");
        return bookService.selectAllBooks();
    }
    /**
     * @Description :通过id进行查询
     * @param id
     * @return : com.aaa.yk.springcloud.model.Book
     * @author : yk
     * @date : 2020/06/24 16:47
     */
    @PostMapping("/byId")
    public Book selectBookById(@RequestParam("id") Long id){
        return bookService.selectBookById(id);
    }
}
