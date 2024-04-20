package com.udea.josukestore.dominio.user.validations;

import org.springframework.stereotype.Component;

import com.udea.josukestore.dominio.user.UserRepository;
import com.udea.josukestore.dominio.user.dto.EmployeRegistrationData;
import com.udea.josukestore.dominio.user.dto.UserResgistrationData;
import com.udea.josukestore.infra.exceptions.CustomValidationException;

@Component
public class UserEmailValidation implements UserValidator {
    
    private UserRepository userRepository;

    public UserEmailValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserResgistrationData user) {
        validateEmail(user.email());
    }

    @Override
    public void validate(EmployeRegistrationData employe) {
        validateEmail(employe.email());
    }

    private void validateEmail(String email) {
        if (this.userRepository.existsByEmail(email)){
            throw new CustomValidationException("email",
                    "The email (" + email + ") is already in use.");
        }
    }
}


