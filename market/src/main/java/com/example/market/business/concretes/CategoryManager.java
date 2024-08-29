package com.example.market.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.business.abstracts.CategoryService;
import com.example.market.core.mappers.ModelMapperService;
import com.example.market.core.response.GetCategoryResponse;
import com.example.market.core.response.GetSubCategoryResponse;
import com.example.market.dataAccess.abstracts.CategoryRepository;
import com.example.market.entities.concretes.Category;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryManager implements  CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
     @Autowired
    private ModelMapperService modelMapperService;
    @Override
    public List<GetCategoryResponse> getCategoryResponse() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(category -> {
            // Category entity'sini GetCategoryResponse'a map et
            GetCategoryResponse categoryResponse = modelMapperService.forResponse().map(category, GetCategoryResponse.class);

            // SubCategory -> GetSubCategoryResponse dönüşümü (getter olmadan)
            List<GetSubCategoryResponse> subCategoryResponses = category.getSubCategories().stream()
                    .map(subCategory -> modelMapperService.forResponse().map(subCategory, GetSubCategoryResponse.class))
                    .collect(Collectors.toList());

            // SubCategories'ı set et
            categoryResponse.setSubCategories(subCategoryResponses);

            return categoryResponse;
        }).collect(Collectors.toList());


       
    }

}
