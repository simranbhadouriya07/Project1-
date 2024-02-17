package com.example.Instragram.repo;

import com.example.Instragram.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String newEmail);
}
