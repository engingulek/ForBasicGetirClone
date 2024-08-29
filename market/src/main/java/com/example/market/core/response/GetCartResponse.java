package com.example.market.core.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartResponse {
    private int id;
    
    private String imageurl;
    private String name;
    private String about_product;
    private Float price;
    private int quantity;
    private int product_id;

}
