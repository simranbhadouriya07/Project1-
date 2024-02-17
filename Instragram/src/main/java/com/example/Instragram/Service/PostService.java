package com.example.Instragram.Service;

import com.example.Instragram.Model.Post;
import com.example.Instragram.Model.User;
import com.example.Instragram.repo.IPost;
import com.example.Instragram.repo.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPost iPost;
    @Autowired
    UTokenService uTokenService;
    @Autowired
    IUser iUser;

    public String instrPost(String email, String tokenValue, Post post) {
       if(uTokenService.authenticate(email ,tokenValue )){
           User existingUser = iUser.findFirstByUserEmail(email);
           post.setPostOwner(existingUser);
            iPost.save(post);
           return post.getPostType() + " posted!!";
       }
       else{
            return  "Unauthenticate access";
       }
    }

    public List<Post> getAllPost() {
         return  iPost.findAll();
    }

    public Post getPostById(String id) {
         return iPost.findById(id).get();
    }
}
