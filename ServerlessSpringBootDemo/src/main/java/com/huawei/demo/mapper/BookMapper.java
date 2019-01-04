package com.huawei.demo.mapper;

import com.huawei.demo.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from books")
    List<Book> getAllBooks();

    @Select("select * from books where id = #{id}")
    Book getBook(int id);

    @Insert("insert into books (name, author, price) values (#{name}, #{author}, #{price})")
    void add(Book book);
}
