package com.udea.JosukeStore.controller;

import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employe")
@CrossOrigin("*")
public class EmployeController {


    private UserService userService;

    public EmployeController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserData> registerEmploye(@RequestBody @Valid EmployeRegistrationData employeRegistrationData){
        UserData userData = this.userService.registerEmploye(employeRegistrationData);
        return ResponseEntity.created(null).body(userData);
    }
}
