package com.udea.josukestore.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.udea.josukestore.dominio.user.dto.UserData;
import com.udea.josukestore.dominio.user.dto.UserResgistrationData;
import com.udea.josukestore.dominio.user.interfaces.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
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
