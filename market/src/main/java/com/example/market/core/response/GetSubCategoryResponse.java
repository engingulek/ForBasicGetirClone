package com.example.market.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSubCategoryResponse {
    private int  id;
    private String name;
}
