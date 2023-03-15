package com.muhardin.endy.belajar.springvue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhardin.endy.belajar.springvue.dao.RoleDao;
import com.muhardin.endy.belajar.springvue.entity.Role;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired private RoleDao userDao;

    @GetMapping("/role/")
    public Page<Role> findAll(Pageable pageable){
        return userDao.findAll(pageable);
    }

    @GetMapping("/role/{id}")
    public Role findById(@PathVariable("id") Role role) {
        return role;
    }
}
