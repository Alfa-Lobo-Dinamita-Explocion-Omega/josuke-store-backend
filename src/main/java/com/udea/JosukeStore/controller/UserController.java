package com.udea.JosukeStore.controller;


import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
