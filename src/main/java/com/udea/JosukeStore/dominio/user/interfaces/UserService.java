package com.udea.josukestore.dominio.user.interfaces;

import com.udea.josukestore.dominio.user.dto.EmployeRegistrationData;
import com.udea.josukestore.dominio.user.dto.UserData;
import com.udea.josukestore.dominio.user.dto.UserResgistrationData;

public interface UserService {

    public UserData registerUser(UserResgistrationData userResgistrationData);

}
