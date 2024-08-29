package com.example.market.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.business.abstracts.CartService;
import com.example.market.core.request.CartProductRequest;
import com.example.market.core.response.GetCartResponse;
import com.example.market.dataAccess.abstracts.CartRepository;
import com.example.market.dataAccess.abstracts.ProductRepository;
import com.example.market.dataAccess.abstracts.UserRepository;
import com.example.market.entities.concretes.Cart;
import com.example.market.entities.concretes.Product;
import com.example.market.entities.concretes.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CartManager implements  CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void  addProductToCart(CartProductRequest cartProductRequest) {
      User user = userRepository.findById(cartProductRequest.getUser_id()).orElseThrow();
      Product product = productRepository.findById(cartProductRequest.getProduct_id()).orElseThrow();
      List<Cart> cartListForUser = cartRepository.findByUserId(cartProductRequest.getUser_id());
      int product_id = cartProductRequest.getProduct_id();
      List<Cart> cartList = cartListForUser.stream()
    .filter(c -> product_id == c.getProduct().getId())
    .collect(Collectors.toList());

    if (cartList.isEmpty()){
      Cart cart = new Cart();
      cart.setUser(user);
      cart.setProduct(product);
      cart.setQuantity(1);
      this.cartRepository.save(cart);
    }else{
      final Cart cart = cartList.get(0);
      int oldQuantity = cart.getQuantity();
      int newQuantity = oldQuantity + 1;
      cart.setQuantity(newQuantity);
      this.cartRepository.save(cart);
    }

    }

    @Override
    public void incrementProductFromCart(int id) {
      Cart cart = cartRepository.findById(id).orElseThrow();
      int oldQuantity = cart.getQuantity();
      int newQuantity = oldQuantity + 1;
      cart.setQuantity(newQuantity);
         this.cartRepository.save(cart);
     
    }


    @Override
    public void decreaseProductFromCart(int id) {
      Cart cart = cartRepository.findById(id).orElseThrow();
      if (cart.getQuantity() == 1){
        cartRepository.deleteById(id);
      }else{
        int oldQuantity = cart.getQuantity();
        int newQuantity = oldQuantity - 1;
        cart.setQuantity(newQuantity);
           this.cartRepository.save(cart);
      }
    }

    @Override
    public List<GetCartResponse> getCartByUserId(int userId) {
      List<Cart> cartList = cartRepository.findByUserId(userId);

      //Modelmapper service was not used becasuse modelmapper service gived error on product_id

      List<GetCartResponse> cartResponses = cartList.stream().map(cart -> {
          GetCartResponse response = new GetCartResponse();
          response.setId(cart.getId());
          response.setImageurl(cart.getProduct().getImageUrl());
          response.setName(cart.getProduct().getName());
          response.setAbout_product(cart.getProduct().getAboutProduct());
          response.setPrice(cart.getProduct().getPrice());
          response.setQuantity(cart.getQuantity());
          response.setProduct_id(cart.getProduct().getId()); // product_id burada set ediliyor
          return response;
      }).collect(Collectors.toList());
      return cartResponses;
    }

    @Override
    public void cartFullClear(int userId) {
      cartRepository.deleteAllByUserId(userId);
      
    }

    
    
}
