package com.udea.josukestore.dominio.user.validations;

import com.udea.josukestore.dominio.user.dto.EmployeRegistrationData;
import com.udea.josukestore.dominio.user.dto.UserResgistrationData;

public interface UserValidator {

    public void validate(UserResgistrationData user);

    public void validate(EmployeRegistrationData employeRegistrationData);

}
