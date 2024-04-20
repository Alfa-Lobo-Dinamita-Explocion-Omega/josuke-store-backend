package com.udea.josukestore.dominio.user.validations;

import org.springframework.stereotype.Component;

import com.udea.josukestore.dominio.user.UserRepository;
import com.udea.josukestore.dominio.user.dto.EmployeRegistrationData;
import com.udea.josukestore.dominio.user.dto.UserResgistrationData;
import com.udea.josukestore.infra.exceptions.CustomValidationException;

@Component
public class UserIdUserValidation implements UserValidator {

    private UserRepository userRepository;

    public UserIdUserValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserResgistrationData user) {
        validateIdUser(user.idUser());
    }

    @Override
    public void validate(EmployeRegistrationData employe) {
        validateIdUser(employe.idUser());
    }

    private void validateIdUser(Integer idUser) {
        if (this.userRepository.existsByIdUser(idUser)) {
            throw new CustomValidationException("idUser",
                    "The ID user (" + idUser + ") is already in use.");
        }
    }
}

