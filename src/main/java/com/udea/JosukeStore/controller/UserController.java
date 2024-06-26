package com.udea.JosukeStore.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserData> registerUser(@RequestBody @Valid UserResgistrationData userResgistrationData){
        UserData userData = this.userService.registerUser(userResgistrationData);
        return ResponseEntity.created(null).body(userData);
    }

}
