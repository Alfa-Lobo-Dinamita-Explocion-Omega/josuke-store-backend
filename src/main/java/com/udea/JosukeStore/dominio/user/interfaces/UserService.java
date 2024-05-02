package com.udea.JosukeStore.dominio.user.interfaces;


import com.udea.JosukeStore.dominio.user.dto.BasicUserData;
import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;

public interface UserService {

    public UserData registerUser(UserResgistrationData userResgistrationData);

    public BasicUserData getUserData(Long id);
    
}
