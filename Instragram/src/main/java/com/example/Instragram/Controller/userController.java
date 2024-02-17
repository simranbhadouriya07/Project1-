package com.example.Instragram.Controller;

import com.example.Instragram.Model.Dto.SingINDto;
import com.example.Instragram.Model.User;
import com.example.Instragram.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {
    @Autowired
    UserService userService;
@PostMapping("UserSingUp")
  public String userSingUp(@RequestBody User newUser){
       return  userService.userSingUp(newUser);
  }

   @PostMapping("UserSingIn")
    public String userSingIn(@RequestBody SingINDto singINDto){
       return  userService.userSingIn(singINDto);
   }
   @PutMapping("UpdateAge")
    public String updateUserAge(@RequestParam String email ,@RequestParam String tokenValue, @RequestParam Integer age){
      return userService.updateUserAge(email ,tokenValue,  age);
   }
   @DeleteMapping("User/SingOut")
    public String userSingOut(@RequestParam String email ,@RequestParam String tokenValue){
     return userService.userSingOut(email ,tokenValue);
   }

}
