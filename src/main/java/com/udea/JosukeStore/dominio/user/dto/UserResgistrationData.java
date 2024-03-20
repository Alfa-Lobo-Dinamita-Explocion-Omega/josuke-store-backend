package com.udea.JosukeStore.dominio.user.dto;

import com.udea.JosukeStore.dominio.user.model.Role;

public record UserResgistrationData(
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
) {
}
