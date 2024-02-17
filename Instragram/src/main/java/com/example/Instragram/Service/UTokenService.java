package com.example.Instragram.Service;

import com.example.Instragram.Model.AuthenticationToken;
import com.example.Instragram.repo.IUToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UTokenService {
    @Autowired
    IUToken iuToken;

    public void CreateToken(AuthenticationToken token) {
      iuToken.save(token);
    }

    public boolean authenticate(String email, String tokenValue) {
       AuthenticationToken token = iuToken.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }

    public boolean authenticateToken(String email, String tokenValue) {
        AuthenticationToken token =iuToken.findFirstByTokenValue(tokenValue);
        if(token!=null){

            return true;

        }
        else{
            return false;
        }
    }

    public void singOut(String tokenValue) {
        AuthenticationToken token =iuToken.findFirstByTokenValue(tokenValue);
        iuToken.delete(token);
    }
}
