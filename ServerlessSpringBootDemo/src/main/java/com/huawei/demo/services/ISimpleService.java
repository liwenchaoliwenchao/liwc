package com.huawei.demo.services;

import com.huawei.demo.entity.User;

import java.util.List;

public interface ISimpleService {
    User getUserById(int id);
    
    void updateUser(User u);
    
    void addUserAndBook(User u);
    
    List<User> getUsers();
    
    void deleteUser(long id);
}
