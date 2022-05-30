package com.example.project2.controller;

import com.example.project2.model.Api;
import com.example.project2.model.Category;
import com.example.project2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategories(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<Api> addCategories(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(categoryService.isAddCategories(category))){
            return ResponseEntity.status(500).body(new Api("The category is already added",500));
        }
        return ResponseEntity.status(200).body(new Api("The category is added",200));
    }

    @PutMapping
    public ResponseEntity<Api> updateCategories(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(categoryService.isUpdateCategories(category))){
            return ResponseEntity.status(500).body(new Api("The category is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The category is updated",200));
    }

    @DeleteMapping
    public ResponseEntity<Api> deleteCategories(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(categoryService.isDeleteCategories(category))){
            return ResponseEntity.status(500).body(new Api("The category is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The category is deleted",200));
    }
}
