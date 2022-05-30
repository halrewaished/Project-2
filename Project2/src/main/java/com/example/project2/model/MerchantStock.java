package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "Merchant id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;

    @NotEmpty(message = "Product id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String productId;

    @NotEmpty(message = "merchant id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String merchantId;

    @NotEmpty(message = "Stock is required")
    @Size(min = 10,message = "Have to be more than 10")
    private Integer stock;

}
