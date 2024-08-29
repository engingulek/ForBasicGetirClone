package com.example.market.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.entities.concretes.Product;



public interface  ProductRepository  extends  JpaRepository<Product, Integer>{
    List<Product> findBySubCategoryId(int subCategoryId);
}
