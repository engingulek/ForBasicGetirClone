package com.example.market.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.business.abstracts.ProductService;
import com.example.market.core.mappers.ModelMapperService;
import com.example.market.core.response.GetProductByCategoryId;
import com.example.market.dataAccess.abstracts.ProductRepository;
import com.example.market.entities.concretes.Product;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductManager implements  ProductService {
    @Autowired
    private ProductRepository productRepository;
     @Autowired
    private ModelMapperService modelMapperService;
    @Override
    public List<GetProductByCategoryId> getProductsBySubCategoryId(int subCategoryId) {
        List<Product> products =  productRepository.findBySubCategoryId(subCategoryId);
        List<GetProductByCategoryId> productResponse = products.stream().map(a -> this.modelMapperService.forResponse()
        .map(a, GetProductByCategoryId.class)).collect(Collectors.toList());
        return  productResponse;
    }


    

}
