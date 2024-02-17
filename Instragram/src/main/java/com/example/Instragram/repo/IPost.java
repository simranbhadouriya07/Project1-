package com.example.Instragram.repo;

import com.example.Instragram.Model.Post;
import com.example.Instragram.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPost extends JpaRepository<Post,String> {

}
