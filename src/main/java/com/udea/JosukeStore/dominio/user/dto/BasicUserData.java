package com.udea.JosukeStore.dominio.user.dto;


import com.udea.JosukeStore.dominio.user.model.User;

public record BasicUserData(
        Long id,
        String name,
        String phone,
        int idUser
        ) {
    public BasicUserData(User user){
        this(
            user.getId(),
            user.getName(),
            user.getPhone(),
            user.getIdUser());
    }
}

