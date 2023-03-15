package com.muhardin.endy.belajar.springvue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.belajar.springvue.dao.UserDao;
import com.muhardin.endy.belajar.springvue.dao.UserPasswordDao;
import com.muhardin.endy.belajar.springvue.dto.UserDto;
import com.muhardin.endy.belajar.springvue.entity.User;
import com.muhardin.endy.belajar.springvue.entity.UserPassword;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired private UserDao userDao;
    @Autowired private UserPasswordDao userPasswordDao;

    @GetMapping("/user/")
    public Page<User> findAllUsers(Pageable pageable){
        return userDao.findAll(pageable);
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") User user){
        return user;
    }

    @PostMapping("/user/")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid UserDto userDto){
        User user = new User();
        user.setActive(userDto.getActive());
        user.setUsername(userDto.getUsername());

        UserPassword userPassword = new UserPassword();
        userPassword.setPassword(userDto.getPassword());

        user.setRole(userDto.getRole());
        userPassword.setUser(user);

        userDao.save(user);
        userPasswordDao.save(userPassword);
        return user;
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User create(@RequestBody @Valid User userForm, @PathVariable("id") User userDb){
        userForm.setId(userDb.getId());
        userDao.save(userForm);
        return userForm;
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String userId){
        userPasswordDao.deleteById(userId);
        userDao.deleteById(userId);
    }
}
