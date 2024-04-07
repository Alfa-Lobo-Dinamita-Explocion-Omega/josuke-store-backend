package com.udea.JosukeStore.dominio.user.interfaces;

import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;

public interface UserService {

    public UserData registerUser(UserResgistrationData userResgistrationData);

    public UserData registerEmploye(EmployeRegistrationData employeRegistrationData);

}
