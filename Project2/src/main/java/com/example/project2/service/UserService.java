package com.example.project2.service;

import com.example.project2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ArrayList<User> users = new ArrayList<>();

    private final PurchaseHistoryService purchaseHistoryService;
    private final CommentService commentService;

    public ArrayList<User> getUsers(){

        return users;
    }

    public boolean isAddUsers(User user){
        for (int i = 0; i < users.size() ; i++) {
            if(users.get(i).getId().equals(user.getId())){
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public boolean isUpdateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(user.getId())){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean isDeleteUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(user.getId())){
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public User getUsers(String userId) {
        for (User user : users) {
            if(user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public boolean getRates(String userId){
        if(userId == null){
            return false;
        }
        commentService.getRates(userId);
        return true;
    }

    public boolean getHistory(String userId){
        if(userId == null){
            return false;
        }
        purchaseHistoryService.getPurchaseHistory(userId);
        return true;
    }

}
