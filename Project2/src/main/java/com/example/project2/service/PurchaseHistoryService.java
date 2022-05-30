package com.example.project2.service;

import com.example.project2.model.PurchaseHistory;
import com.example.project2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryService {

    private final ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<>();


    public ArrayList<PurchaseHistory> getPurchaseHistory(){

        return purchaseHistories;
    }

    public boolean addPurchaseHistory(String userId, String productId, Integer price){
        PurchaseHistory purchaseHistory = new PurchaseHistory(userId,productId,price);
        return purchaseHistories.add(purchaseHistory);
    }

    public ArrayList<PurchaseHistory> getPurchaseHistory(String userId){
        for ( PurchaseHistory p : purchaseHistories) {
            if(p.getUserId().equals(userId)){
                return purchaseHistories;
            }
        }
        return null;
    }

}
