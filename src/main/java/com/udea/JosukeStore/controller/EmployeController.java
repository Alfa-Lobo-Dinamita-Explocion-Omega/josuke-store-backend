package com.udea.JosukeStore.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.interfaces.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeController {


    private EmployeService employeService;

    public EmployeController(EmployeService employeService){
        this.employeService = employeService;
    }

    @PostMapping
    public ResponseEntity<UserData> registerEmploye(@RequestBody @Valid EmployeRegistrationData employeRegistrationData){
        UserData userData = this.employeService.registerEmploye(employeRegistrationData);
        return ResponseEntity.created(null).body(userData);
    }
}
