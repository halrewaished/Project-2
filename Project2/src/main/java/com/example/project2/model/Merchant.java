package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class Merchant {

    @NotEmpty(message = "Merchant id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;

    @NotEmpty(message = "Name is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String name;
}
