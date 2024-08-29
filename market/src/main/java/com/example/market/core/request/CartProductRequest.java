package com.example.market.core.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductRequest {
    private int user_id;
    private int product_id;
   
}
