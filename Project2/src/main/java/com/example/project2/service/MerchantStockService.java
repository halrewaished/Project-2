package com.example.project2.service;

import com.example.project2.model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    private final ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock(){

        return merchantStocks;
    }

    public boolean isAddMerchantStock(MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getMerchantId().equals(merchantStock.getId())){
                return false;
            }
        }
        merchantStocks.add(merchantStock);
        return true;
    }

    public boolean isUpdateMerchantStock(MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getMerchantId().equals(merchantStock.getMerchantId())){
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean isDeleteMerchantStock(MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getMerchantId().equals(merchantStock.getMerchantId())){
                return merchantStocks.remove(merchantStock);
            }
        }
        return false;
    }

    public MerchantStock getMerchantStock(String merchantId){
        for (MerchantStock merchantStock : merchantStocks) {
            if(merchantStock.getId().equals(merchantId)){
                return merchantStock;
            }
        }
        return null;
    }
}
