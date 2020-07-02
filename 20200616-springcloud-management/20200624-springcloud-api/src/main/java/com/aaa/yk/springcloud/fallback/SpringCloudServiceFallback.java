package com.aaa.yk.springcloud.fallback;

import com.aaa.yk.springcloud.model.Book;
import com.aaa.yk.springcloud.service.SpringcloudService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Param
 * @ClassName SpringCloudServiceFallback
 * @Description
 * @Author yk
 * @Date 2020/7/1 0001 20:02
 * @Return
 **/
@Component
public class SpringCloudServiceFallback implements FallbackFactory<SpringcloudService> {
    /**
     * @Description :该方法就是用于熔断的所有方法
     * @param throwable
     * @return : com.aaa.yk.springcloud.service.SpringcloudService
     * @author : yk
     * @date : 2020/07/01 20:04
     */
    public SpringcloudService create(Throwable throwable) {
        SpringcloudService springcloudService = new SpringcloudService() {
            public List<Book> selectAllBooks() {
                System.out.println("我是备用方法，我被访问了");
                List<Book> bookList = new ArrayList<Book>();
                Book book = new Book().setId(10000L).setBookName("测试备用方法").setBookPrice(18.8);
                bookList.add(book);
                return bookList;
            }

            public String allBooks() {
                return null;
            }

            public Book selectBookById(Long id) {
                return null;
            }
        };
        return springcloudService;
    }
}
