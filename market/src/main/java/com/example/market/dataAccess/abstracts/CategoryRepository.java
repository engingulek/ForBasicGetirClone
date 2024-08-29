package com.example.market.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.concretes.Category;

public interface CategoryRepository extends  JpaRepository<Category, Integer> {
    
}
