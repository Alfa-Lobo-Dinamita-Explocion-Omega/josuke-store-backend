package com.udea.josukestore.dominio.user.dto;

import com.udea.josukestore.dominio.user.model.Role;
import com.udea.josukestore.dominio.user.model.User;

public record UserData(
        String name,
        String email,
        String phone,
        int idUser,
        String address,
        String city,
        String department,
        String country,
        String potalCode,
        Role role) {
    public UserData(User user){
        this(
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getIdUser(),
                user.getAddress(),
                user.getCity(),
                user.getDepartment(),
                user.getCountry(),
                user.getPotalCode(),
                user.getRole());
    }
}
