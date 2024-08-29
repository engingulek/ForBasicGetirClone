package com.example.market.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByCategoryId {
    private int id;
    private String imageUrl;
    private String name;
    private Float price;
    private String aboutProduct;
}
