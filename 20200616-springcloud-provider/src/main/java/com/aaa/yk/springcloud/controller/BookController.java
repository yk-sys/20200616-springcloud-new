package com.aaa.yk.springcloud.controller;

import com.aaa.yk.springcloud.model.Book;
import com.aaa.yk.springcloud.model.LayuiTable;
import com.aaa.yk.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
//@Controller
/*@RequestMapping("/book")*/
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping(value = "/all", produces="application/json")
    public List<Book> allBooks(){
        System.out.println("8081");
        return bookService.selectAllBooks();
    }


    @RequestMapping(value = "/all1", produces="application/json")
    public String  allBooks(Model model){
        System.out.println("8081");
        model.addAttribute("username","zhangsan");
        List<Book> bookList = bookService.selectAllBooks();
        model.addAttribute("bookList",bookList);
        return "showAllBook";
    }

    @RequestMapping("/allBooks")
    @ResponseBody
    public LayuiTable ShowAllPageAjax(){
        LayuiTable layuiTable = new LayuiTable();
        List<Book> bookList = bookService.selectAllBooks();
        layuiTable.setCode(0);
        layuiTable.setMsg("操作成功");
        layuiTable.setCount(bookList.size());
        layuiTable.setData(bookList);
        return layuiTable;
    }
    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping("/deleteBook")
    @ResponseBody
    public Integer deleteBook(Long id) {
        Integer integer = bookService.deleteById(id);
        if (integer>0){
            return 1;
        }
        return -1;
    }
    /**
     * @Description :修改
     * @param id
     * @return : int
     * @author : yk
     * @date : 2020/06/26 16:22
     */
    @RequestMapping("/updateBook")
    @ResponseBody
    public int updateByPrimaryKey(Book id){
        return bookService.updateByPrimaryKey(id);
    }
    /**
     * @Description :添加
     * @param id
     * @return : int
     * @author : yk
     * @date : 2020/06/26 16:33
     */
    @RequestMapping("/insertBook")
    @ResponseBody
    public int insert(Book id){
        return bookService.insert(id);
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
