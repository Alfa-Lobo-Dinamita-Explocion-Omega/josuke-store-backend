package com.udea.josukestore.dominio.user.dto;

import com.udea.josukestore.dominio.user.model.Role;

public record EmployeRegistrationData(
        String name,
        String email,
        String phone,
        int idUser,
        String address,
        String city,
        String department,
        String country,
        String postalCode,
        String userName,
        String password,
        Role role
){

}
