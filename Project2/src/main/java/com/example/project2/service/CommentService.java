package com.example.project2.service;

import com.example.project2.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ArrayList<Comment> comments = new ArrayList<>();

    public ArrayList<Comment> getComments(){

        return comments;
    }

    public String getComments(String userId) {
        for (Comment comment : comments) {
            if(comment.getUserId().equals(userId)){
                return comment.getMessage();
            }
        }
        return null;
    }

    public ArrayList<Comment> getRates(String userId) {
        ArrayList<Comment> newComment = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            if(comments.get(i).getRate() == "5"){
                newComment.add(comments.get(i));
                return newComment;
        }
        }
        return null;
    }
}
