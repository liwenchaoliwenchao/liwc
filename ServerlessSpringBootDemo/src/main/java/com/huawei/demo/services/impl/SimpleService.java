package com.huawei.demo.services.impl;

import com.huawei.demo.services.ISimpleService;
import com.huawei.demo.entity.Book;
import com.huawei.demo.entity.User;
import com.huawei.demo.mapper.BookMapper;
import com.huawei.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimpleService implements ISimpleService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public User getUserById(int id) {
        return mapper.getUserbyId(id);
    }
    
    @Override
    public void updateUser(User u) {
        mapper.update(u);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserAndBook(User u) {
        Book book = new Book();
        book.setAuthor("Anne");
        book.setName("Anne's diary");
        book.setPrice(15.9f);
        bookMapper.add(book);
        mapper.insert(u);
    }
    
    @Override
    public List<User> getUsers() {
        return mapper.getAll();
    }
    
    @Override
    public void deleteUser(long id) {
        mapper.delete(id);
    }
}
