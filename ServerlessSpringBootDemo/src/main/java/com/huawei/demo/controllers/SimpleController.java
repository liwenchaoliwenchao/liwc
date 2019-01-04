package com.huawei.demo.controllers;

import com.huawei.demo.entity.SomethingToReturn;
import com.huawei.demo.entity.User;
import com.huawei.demo.services.ISimpleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/webtest", "/simple"})
public class SimpleController {  
    @Autowired
    private ISimpleService service;

    private static Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @RequestMapping("hello")
    public String hello(){
        return "test";
    }
    
    @RequestMapping("test")
    public SomethingToReturn test(){
        return new SomethingToReturn("test hello", 41);
    }
    
    @RequestMapping("user")
    public User getUserById(@RequestParam int id) {
        return service.getUserById(id);
    }

    @RequestMapping(value="users/{id}", method=RequestMethod.PUT)
    public String updateUser(User u, @PathVariable int cid) {
        u.setId(cid);
        service.updateUser(u);
        return "";
    }

    @RequestMapping(value= "users", method = RequestMethod.POST)
    public String addUser(User u, @RequestHeader("X-Auth-Token") String token) {
        logger.warn("token is: {}", token);
        try {
            service.addUserAndBook(u);
        } catch (Exception e) {
            logger.error("Exception occurred when trying to add book and user: {}", e.getMessage());
        }
        return "add user ok";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return service.getUsers();
    }
    
    @RequestMapping(value="users/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable("id")int id) {
        return service.getUserById(id);
    }
    
    @RequestMapping(value="users/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id")long id) {
        service.deleteUser(id);
        return "ok";
    }
}
