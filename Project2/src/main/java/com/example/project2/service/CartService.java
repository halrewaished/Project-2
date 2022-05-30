package com.example.project2.service;

import com.example.project2.model.Cart;
import com.example.project2.model.Product;
import com.example.project2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ArrayList<Cart> carts = new ArrayList<>();

    private final UserService userService;

    private final ProductService productService;

    public ArrayList<Cart> getCarts(){

        return carts;
    }

    public Integer addProductToCart(String userId,String productId) {
        User currentUser = userService.getUsers(userId);
        Product currentProduct = productService.getProducts(productId);

        if(currentUser == null){
            return -1;
        }
        if(currentProduct == null){
            return 0;
        }

        for ( Cart cart : carts) {
            if(cart.getUserId().equals(userId)){
                cart.getProducts().add(currentProduct);
                return 1;
                }
            }
       return 2;
    }

    public Integer removeFromCart(String userId, String productId){

        User currentUser = userService.getUsers(userId);
        Product currentProduct = productService.getProducts(productId);

        if(currentUser == null){
            return -1;
        }
        if(currentProduct == null){
            return 0;
        }
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUserId().equals(userId)) {
                carts.remove(productId);
                return 1;
            }
        }
        return 2;
    }

    }