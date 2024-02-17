package com.example.Instragram.Controller;

import com.example.Instragram.Model.Post;
import com.example.Instragram.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class postController {
    @Autowired
    PostService postService;

    @PostMapping("Post")
    public String instrPost(@RequestParam String email , @RequestParam String tokenValue , @RequestBody Post post){
        return postService.instrPost( email,tokenValue,post);
    }
   @GetMapping("Posts")
    public List<Post> getAllPost(){
         return  postService.getAllPost();
   }
    @GetMapping("Post/{id}")
    public  Post getPostById(@PathVariable String id ){
        return postService.getPostById(id);
    }
}
