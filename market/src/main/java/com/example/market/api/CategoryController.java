package com.example.market.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.business.abstracts.CategoryService;
import com.example.market.core.response.GetCategoryResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/category/")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("getAll")
    public List<GetCategoryResponse> getAll(){
        return categoryService.getCategoryResponse();
    }

      
}
