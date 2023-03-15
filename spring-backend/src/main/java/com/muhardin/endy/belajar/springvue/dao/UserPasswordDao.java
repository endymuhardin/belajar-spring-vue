package com.muhardin.endy.belajar.springvue.dao;

import org.springframework.data.repository.CrudRepository;

import com.muhardin.endy.belajar.springvue.entity.UserPassword;

public interface UserPasswordDao extends CrudRepository<UserPassword, String> {
    
}
