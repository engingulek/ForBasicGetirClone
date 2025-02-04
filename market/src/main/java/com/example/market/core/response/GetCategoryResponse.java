package com.example.market.core.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse {
   private int id;
   private  String name;
  private List<GetSubCategoryResponse> subCategories;
}


