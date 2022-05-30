package com.example.project2.controller;

import com.example.project2.model.Api;
import com.example.project2.model.Merchant;
import com.example.project2.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getMerchants(){
        return ResponseEntity.status(200).body(merchantService.getMerchants());
    }

    @PostMapping
    public ResponseEntity<Api> addMerchants(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(merchantService.isAddMerchants(merchant))){
            return ResponseEntity.status(500).body(new Api("The merchant is already added",500));
        }
        return ResponseEntity.status(200).body(new Api("The merchant is added",200));
    }

    @PutMapping
    public ResponseEntity<Api> updateMerchants(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(merchantService.isUpdateMerchants(merchant))){
            return ResponseEntity.status(500).body(new Api("The merchant is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The merchant is updated",200));
    }

    @DeleteMapping
    public ResponseEntity<Api> deleteMerchants(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        if(!(merchantService.isDeleteMerchants(merchant))){
            return ResponseEntity.status(500).body(new Api("The merchant is not exist",500));
        }
        return ResponseEntity.status(200).body(new Api("The merchant is deleted",200));
    }
}
