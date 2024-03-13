package com.udea.JosukeStore.dominio.user.dto;

import com.udea.JosukeStore.dominio.user.model.Role;
import com.udea.JosukeStore.dominio.user.model.User;

public record UserData(
        String name,
        String email,
        String phone,
        int idUser,
        String address,
        String city,
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
                user.getPotalCode(),
                user.getRole());
    }
}
