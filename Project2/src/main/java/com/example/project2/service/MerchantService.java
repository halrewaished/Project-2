package com.example.project2.service;

import com.example.project2.model.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchants(){

        return merchants;
    }

    public boolean isAddMerchants(Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(merchant.getId())){
                return false;
            }
        }
        merchants.add(merchant);
        return true;
    }

    public boolean isUpdateMerchants(Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(merchant.getId())){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }

    public boolean isDeleteMerchants(Merchant merchant){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(merchant.getId())){
                return merchants.remove(merchant);
            }
        }
        return false;
    }
}
