package com.example.project2.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

    @NotEmpty(message = "Category id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;

    @NotEmpty(message = "Category id is required")
    @Size(max = 5,message = "Have to be 5 character")
    private String username;

    @NotEmpty(message = "Category id is required")
    @Size(max = 6,message = "Have to be 6 character")
    private String password;

    @NotEmpty(message = "Category id is required")
    @Email(message = "Email is required")
    private String email;

    @NotEmpty(message = "Category id is required")
    @Pattern(regexp = "(Admin|Customer)")
    private String role;

    @NotNull(message = "Balance is required")
    @Positive(message = "Balance must be positive")
    private Integer balance;

}
