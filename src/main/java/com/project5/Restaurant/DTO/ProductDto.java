package com.project5.Restaurant.DTO;

import lombok.Data;

@Data
public class ProductDto {


    int productId;
    String categoryName;
    String productName;
    int productPrice;
    String productUnit;
    String productDetails;
    String productImage;
    String productStatus;
    int productQuanity;
}
