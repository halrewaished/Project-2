package com.example.project2.controller;

import com.example.project2.model.Api;
import com.example.project2.model.Cart;
import com.example.project2.model.Comment;
import com.example.project2.model.Product;
import com.example.project2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProducts() {
        return ResponseEntity.status(200).body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Api> addProducts(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        if (!(productService.isAddProduct(product))) {
            return ResponseEntity.status(500).body(new Api("The product is already added", 500));
        }
        return ResponseEntity.status(200).body(new Api("The product is added", 200));
    }

    @PutMapping
    public ResponseEntity<Api> updateProducts(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        if (!(productService.isUpdateProduct(product))) {
            return ResponseEntity.status(500).body(new Api("The product is not exist", 500));
        }
        return ResponseEntity.status(200).body(new Api("The product is updated", 200));
    }

    @DeleteMapping
    public ResponseEntity<Api> deleteProducts(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        if (!(productService.isDeleteProduct(product))) {
            return ResponseEntity.status(500).body(new Api("The product is not exist", 500));
        }
        return ResponseEntity.status(200).body(new Api("The product is deleted", 200));
    }

    @PostMapping("/buy")
    public ResponseEntity<Api> buyProductDirectly(@RequestParam String userId, @RequestParam String productId, String merchantID) {

        Integer buyStatus = productService.buyProductDirectly(userId, productId, merchantID);
        switch (buyStatus) {
            case -1:
                return ResponseEntity.status(400).body(new Api("The stock is empty", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("The balance of user less than price of product", 400));
            case 1:
                return ResponseEntity.status(400).body(new Api("The product is not in stock", 400));
            case 2:
                return ResponseEntity.status(200).body(new Api("The product purchased", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }
    }

    @GetMapping("/comment")
    public ResponseEntity<Api> getComments(@RequestParam String userId, @RequestParam String productId) {
        Integer commentsStatus = productService.getComments(userId, productId);
        switch (commentsStatus) {
            case -1:
                return ResponseEntity.status(400).body(new Api("The user id wrong", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("The product is wrong", 400));
            case 1:
                return ResponseEntity.status(200).body(new Api("The comment getting", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }
    }

    @PostMapping("/stock")
    public ResponseEntity<Api> addProductToMerchantStock(@PathVariable String userId, @PathVariable String productId, @PathVariable String merchantId, Integer stock) {
        Integer addStatus = productService.addProductToMerchantStock(userId, productId, merchantId, stock);
        switch (addStatus) {
            case -1:
                return ResponseEntity.status(400).body(new Api("The user id of product is wrong", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("The merchant stock is wrong", 400));
            case 1:
                return ResponseEntity.status(200).body(new Api("The add is done", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }
    }

    @PostMapping("/buy/cart")
    public ResponseEntity<Api> buyProductWithCart(@RequestParam String userId, @RequestParam String productId, String merchantID, Cart cart) {

        Integer buyStatus = productService.buyProductWithCart(userId, productId, merchantID,cart);
        switch (buyStatus) {
            case -1:
                return ResponseEntity.status(400).body(new Api("The stock is empty", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("The balance of user less than price of product", 400));
            case 1:
                return ResponseEntity.status(400).body(new Api("The product is not in stock", 400));
            case 2:
                return ResponseEntity.status(200).body(new Api("The product purchased", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }
    }


    }

