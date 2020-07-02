package com.aaa.yk.springcloud.controller;

import com.aaa.yk.springcloud.model.Book;
import com.aaa.yk.springcloud.model.LayuiTable;
import com.aaa.yk.springcloud.service.SpringcloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Param
 * @ClassName BookController
 * @Description TODO
 * @Author yk
 * @Date 2020/6/24 0024 16:12
 * @Return
 **/
@RestController
//@Controller
public class BookController {

    @Autowired
    private SpringcloudService springcloudService;

    @GetMapping("/allFeign")
    public List<Book> selectAllBooks(){
        return springcloudService.selectAllBooks();
    }



    @GetMapping("/byId")
    public Book selectBookById(Long id){
        return springcloudService.selectBookById(id);
    }

}
