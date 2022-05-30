package com.example.project2.controller;

import com.example.project2.model.Api;
import com.example.project2.model.User;
import com.example.project2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<Api> addUsers(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(userService.isAddUsers(user))){
            return ResponseEntity.status(500).body(new Api("The user is already added",500));
        }
        return ResponseEntity.status(200).body(new Api("The user is added",200));
    }

    @PutMapping
    public ResponseEntity<Api> updateUsers(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(userService.isUpdateUser(user))){
            return ResponseEntity.status(500).body(new Api("The user is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The user is updated",200));
    }

    @DeleteMapping
    public ResponseEntity<Api> deleteUsers(@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(userService.isDeleteUser(user))){
            return ResponseEntity.status(500).body(new Api("The user is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The user is deleted",200));
    }

    @GetMapping("/history")
    public ResponseEntity<Api> getHistory(@RequestParam String userId){
        if(!(userService.getHistory(userId))){
            return ResponseEntity.status(500).body(new Api("The user id is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The history of user getting ",200));
    }

}

