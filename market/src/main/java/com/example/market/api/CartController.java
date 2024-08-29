package com.example.market.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.business.abstracts.CartService;
import com.example.market.core.request.CartProductRequest;
import com.example.market.core.response.GetCartResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/cart/")
@AllArgsConstructor
@NoArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("getCartByUserId")
    public List<GetCartResponse> getCartListByUserId(@RequestParam int userId){
      return cartService.getCartByUserId(userId);
    }

    @PostMapping("addProduct")
    public void addProductToCart(@RequestBody CartProductRequest cartProductRequest){
      cartService.addProductToCart(cartProductRequest);
 
    }

    @GetMapping("incrementProduct")
    public void incrementProduct(@RequestParam int id){
      cartService.incrementProductFromCart(id);
    }

    @GetMapping("decreaseProduct")
    public void decreaseProduct(@RequestParam int id){
      cartService.decreaseProductFromCart(id);
    }

    @DeleteMapping("clearCart/{userId}")
    public void clearCartByUserId(@PathVariable int userId) {
      cartService.cartFullClear(userId);
    }
}
