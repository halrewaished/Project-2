package com.example.project2.controller;


import com.example.project2.model.Api;
import com.example.project2.model.Cart;
import com.example.project2.service.CartService;
import com.example.project2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getCarts(){
        return ResponseEntity.status(200).body(cartService.getCarts());
    }

    @PostMapping("/add")
    public ResponseEntity<Api> addToCart(@RequestParam String userId, @RequestParam String productId, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }

        Integer addCase = cartService.addProductToCart(userId, productId);

        switch (addCase) {
            case -1:
                return ResponseEntity.status(400).body(new Api("The user id wrong", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("The product id wrong", 400));
            case 1:
                return ResponseEntity.status(200).body(new Api("The product added to cart", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Api> deleteFromCart(@RequestParam String userId, @RequestParam String productId, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        Integer removeCase = cartService.removeFromCart(userId, productId);

        switch (removeCase) {
            case -1:
                return ResponseEntity.status(400).body(new Api("The user id wrong", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("The product id wrong", 400));
            case 1:
                return ResponseEntity.status(200).body(new Api("The product delete from cart", 200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error", 500));
        }

    }
}
