package com.example.market.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.concretes.User;

public interface  UserRepository extends  JpaRepository<User, Integer>{
    
}
