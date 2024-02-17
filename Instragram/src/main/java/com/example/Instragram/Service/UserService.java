package com.example.Instragram.Service;

import com.example.Instragram.Model.AuthenticationToken;
import com.example.Instragram.Model.Dto.SingINDto;
import com.example.Instragram.Model.User;
import com.example.Instragram.repo.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUser iUser;
    @Autowired
    UTokenService uTokenService;

    public String userSingUp(User newUser) {
        String newEmail = newUser.getUserEmail();
        User existingUser=iUser.findFirstByUserEmail(newEmail);
        if(existingUser !=null){
            return "user is already exist";
        }
        String singUpPassword =newUser.getPassword();

        try {
            String encryptedPassword =PasswordEncryptor.encrypt(singUpPassword);
            newUser.setPassword(encryptedPassword);
            iUser.save(newUser);
            return " user is created";

        } catch (NoSuchAlgorithmException e) {
            return  "Internal server error try again some time  ";
        }
    }

    public String userSingIn(SingINDto singINDto) {
        String email= singINDto.getEmail();
        User existingUser= iUser.findFirstByUserEmail(email);
        if(existingUser ==null){
            return " user is not singUp ";
        }
        String password= singINDto.getPassword();

        try {
            String encryptedPassword =PasswordEncryptor.encrypt(password);

            if(encryptedPassword.equals(encryptedPassword)){
                AuthenticationToken token =new AuthenticationToken(existingUser);
                uTokenService.CreateToken(token);
                return token.getTokenValue();
            }
            else{
                return  "password is wrong ";
            }
        } catch (NoSuchAlgorithmException e) {
            return  "Internal server error try again some time  ";
        }
    }


    public String updateUserAge(String email, String tokenValue, Integer age) {
        if(uTokenService.authenticateToken(email ,tokenValue )){
            User existingUser = iUser.findFirstByUserEmail(email);
            existingUser.setAge(age);
            iUser.save(existingUser);
            return "updated";
        }
        else{
            return  "Unauthenticate access";
        }
    }

    public String userSingOut(String email, String tokenValue) {
        if(uTokenService.authenticateToken(email ,tokenValue )){
            User existingUser = iUser.findFirstByUserEmail(email);
            uTokenService.singOut(tokenValue);

            return "User sing out is done ";
        }
        else{
            return  "Unauthenticate access";
        }
    }
}
