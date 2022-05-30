package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor
public class Comment {

    @NotEmpty(message = "Comment id is required")
    @Size(max = 3,message = "Have to be 3 character")
    private String id;
    @NotEmpty(message = "User id is required")
    @Size(max = 5,message = "Have to be 3 character")
    private String userId;

    @NotEmpty(message = "Message is required")
    @Size(max = 6,message = "Have to be 3 character")
    private String message;

    @NotEmpty(message = "Rate is required")
    @Size(min = 1, max = 5,message = "Have to be between 1-5 character")
    private String rate;

}
