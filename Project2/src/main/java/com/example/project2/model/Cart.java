package com.example.project2.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {
    @NotEmpty(message = "Cart id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;
    @NotEmpty(message = "User id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String userId;
    private ArrayList<Product> products;

    public Cart(String id, String userId, ArrayList<Product> products) {
        this.id = id;
        this.userId = userId;
        this.products = new ArrayList<>();
    }

}
