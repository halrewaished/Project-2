package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class PurchaseHistory {

    @NotEmpty(message = "Purchase history id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;

    @NotEmpty(message = "User id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String userId;

    @NotEmpty(message = "Category id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String productId;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Integer price;

    public PurchaseHistory(String userId, String productId, Integer price) {
        this.userId = userId;
        this.productId = productId;
        this.price = price;
    }
}
