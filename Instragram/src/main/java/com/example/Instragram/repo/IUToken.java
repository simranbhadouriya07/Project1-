package com.example.Instragram.repo;

import com.example.Instragram.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUToken extends JpaRepository<AuthenticationToken ,Long> {

    AuthenticationToken findFirstByTokenValue(String tokenValue);
}
