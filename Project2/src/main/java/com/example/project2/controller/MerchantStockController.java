package com.example.project2.controller;

import com.example.project2.model.Api;
import com.example.project2.model.MerchantStock;
import com.example.project2.service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }

    @PostMapping
    public ResponseEntity<Api> addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),500));
        }
        if(!(merchantStockService.isAddMerchantStock(merchantStock))){
            return ResponseEntity.status(500).body(new Api("The merchant stock id is already added",500));
        }
        return ResponseEntity.status(200).body(new Api("The merchant stock id is added",200));
    }

    @PutMapping
    public ResponseEntity<Api> updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),500));
        }
        if(!(merchantStockService.isUpdateMerchantStock(merchantStock))){
            return ResponseEntity.status(500).body(new Api("The merchant stock id is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The merchant stock id is updated",200));
    }

    @DeleteMapping
    public ResponseEntity<Api> deleteMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),500));
        }
        if(!(merchantStockService.isDeleteMerchantStock(merchantStock))){
            return ResponseEntity.status(500).body(new Api("The merchant stock id is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The merchant stock id is deleted",200));
    }
}
