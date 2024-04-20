package com.udea.JosukeStore.dominio.user.validations;

import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;

public interface UserValidator {

    public void validate(UserResgistrationData user);

    public void validate(EmployeRegistrationData employeRegistrationData);

}
