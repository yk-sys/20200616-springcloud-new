package com.aaa.yk.springcloud.service;

import com.aaa.yk.springcloud.mapper.BookMapper;
import com.aaa.yk.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Param
 * @ClassName BookService
 * @Description TODO
 * @Author yk
 * @Date 2020/6/16 0016 16:09
 * @Return
 **/
@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * @Description :查询所有的图书信息
     * @return : java.util.List<com.aaa.yk.springcloud.model.Book>
     * @author : yk
     * @date : 2020/06/16 16:13
     */
    public List<Book> selectAllBooks(){
        return bookMapper.selectAll();
    }
    /**
     * @Description :通过id查询图书信息
     * @param id
     * @return : com.aaa.yk.springcloud.model.Book
     * @author : yk
     * @date : 2020/06/24 16:46
     */
    public Book selectBookById(Long id){
        return bookMapper.selectByPrimaryKey(id);
    }
    /**
     * @Description :删除
     * @param id
     * @return : int
     * @author : yk
     * @date : 2020/06/26 15:57
     */
    public int deleteById(Long id){
        return bookMapper.deleteByPrimaryKey(id);
    }
    /**
     * @Description :修改
     * @param id
     * @return : int
     * @author : yk
     * @date : 2020/06/26 16:21
     */
    public int updateByPrimaryKey(Book id){
        return bookMapper.updateByPrimaryKey(id);
    }
/**
 * @Description :添加
 * @param id
 * @return : int
 * @author : yk
 * @date : 2020/06/26 16:32
 */
    public int insert(Book id){
        return bookMapper.insert(id);
    }
}
