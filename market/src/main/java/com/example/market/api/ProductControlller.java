package com.example.market.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.business.abstracts.ProductService;
import com.example.market.core.response.GetProductByCategoryId;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@RestController
@RequestMapping("api/product/")
@AllArgsConstructor
@NoArgsConstructor
public class ProductControlller {
     @Autowired
     private ProductService productService;

     @GetMapping("bySubCategoryId")
     public List<GetProductByCategoryId> productsGetSubCategory(@RequestParam int subCategoryId){
        return  productService.getProductsBySubCategoryId(subCategoryId);
     }

}
