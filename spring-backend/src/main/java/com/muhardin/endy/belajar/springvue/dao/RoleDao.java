package com.muhardin.endy.belajar.springvue.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.muhardin.endy.belajar.springvue.entity.Role;

public interface RoleDao extends CrudRepository<Role, String>, PagingAndSortingRepository<Role, String> {
    
}
