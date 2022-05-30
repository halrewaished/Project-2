package com.example.project2.model;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Product {
    @NotEmpty(message = "Product id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;
    @NotEmpty(message = "Name is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String name;
    @NotNull(message = "Price is required")
    @Positive(message = "price must be positive")
    private Integer price;
    @NotEmpty(message = "Category id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String categoryId;
    private ArrayList<Comment> comments;

    public Product(String id, String name, Integer price, String categoryId, ArrayList<Comment> comments) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.comments = new ArrayList<>();
    }
}
