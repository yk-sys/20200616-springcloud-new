package com.aaa.yk.springcloud.service;

import com.aaa.yk.springcloud.fallback.SpringCloudServiceFallback;
import com.aaa.yk.springcloud.model.Book;
import com.aaa.yk.springcloud.model.LayuiTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Param
 * @ClassName SpringcloudService
 * @Description @FeignClient():标识了让feign知道所有的provider是谁
 *              使用provider项目中application.properties文件中的spring.application的值
 *
 *              feign中的@GetMapping("/all")一定要和provider中的controller中的GetMapping一模一样（包括请求方式）
 *
 *              在provider2.x版本之后，这个api只能出现一个，所以在起名的时候一定要规范，不要再用Book,Order...这些命名
 *              可以使用项目名进行命名
 *
 *              在feign中进行传递的时候必须要使用注解，如果不使用注解则无法传递（直接抛出异常）
 *              @ResponseBody------>用于包装类型（User对象，Book对象，Map对象...）
 *              @ResquestParam----->用于传递简单类型（String,Integer,Long,Double...）
 *              在feign和provider中都得添加，否则映射不到
 * @Author yk
 * @Date 2020/6/24 0024 16:15
 * @Return
 **/
@FeignClient(value = "book-interface" , fallbackFactory = SpringCloudServiceFallback.class)
public interface SpringcloudService {

    @GetMapping("/all")
    List<Book> selectAllBooks();

    @RequestMapping(value = "/all", produces="application/json")
     String  allBooks();
    /**
     * @Description :通过id查询图书信息
     * @param id
     * @return : com.aaa.yk.springcloud.model.Book
     * @author : yk
     * @date : 2020/06/24 16:42
     */
    @PostMapping("/byId")
    Book selectBookById(@RequestParam("id") Long id);


}
