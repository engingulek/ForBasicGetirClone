package com.example.market.business.abstracts;

import java.util.List;

import com.example.market.core.response.GetProductByCategoryId;

public interface  ProductService {
    List<GetProductByCategoryId> getProductsBySubCategoryId(int subCategoryId);
      
}
