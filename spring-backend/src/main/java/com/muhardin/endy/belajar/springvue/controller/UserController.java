package com.muhardin.endy.belajar.springvue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.belajar.springvue.dao.UserDao;
import com.muhardin.endy.belajar.springvue.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired private UserDao userDao;

    @GetMapping("/user/")
    public Page<User> findAllUsers(Pageable pageable){
        return userDao.findAll(pageable);
    }
}
