package com.udea.JosukeStore.dominio.user.interfaces;

import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserData;

public interface EmployeService {
    public UserData registerEmploye(EmployeRegistrationData employeRegistrationData);

}
