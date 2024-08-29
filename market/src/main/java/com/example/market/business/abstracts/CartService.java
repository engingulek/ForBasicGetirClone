package com.example.market.business.abstracts;

import java.util.List;

import com.example.market.core.request.CartProductRequest;
import com.example.market.core.response.GetCartResponse;

public interface CartService {
    void  addProductToCart(CartProductRequest createProductRequest);
    void incrementProductFromCart(int id);
    void decreaseProductFromCart(int id);
    void cartFullClear(int userId);
    List<GetCartResponse> getCartByUserId(int userId);
}
