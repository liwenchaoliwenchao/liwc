package com.huawei.demo.controllers;

import com.huawei.demo.entity.Book;
import com.huawei.demo.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("webtest")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookMapper bookMapper;

    @ResponseBody
    @RequestMapping({"/books", "/allbooks"})
    public List<Book> getBooks() {
        return bookMapper.getAllBooks();
    }

    @ResponseBody
    @RequestMapping("/books/new")
    public String addBook(@RequestBody Book b) {
        logger.debug("new book {}", b);
        bookMapper.add(b);
        return "add book succeed";
    }

    @ResponseBody
    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookMapper.getBook(id);
    }
}