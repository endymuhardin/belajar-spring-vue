package com.muhardin.endy.belajar.springvue.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.muhardin.endy.belajar.springvue.entity.User;

public interface UserDao extends CrudRepository<User, String>, PagingAndSortingRepository<User, String> {
    
}
