package com.udea.josukestore.dominio.user.interfaces;

import com.udea.josukestore.dominio.user.dto.EmployeRegistrationData;
import com.udea.josukestore.dominio.user.dto.UserData;

public interface EmployeService {
    public UserData registerEmploye(EmployeRegistrationData employeRegistrationData);

}
