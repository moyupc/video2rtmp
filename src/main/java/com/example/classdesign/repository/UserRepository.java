package com.example.classdesign.repository;

import com.example.classdesign.models.UserInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo,Integer> {
    UserInfo findByUsername(String username);
}
