package com.udea.josukestore.dominio.user.validations;

import org.springframework.stereotype.Component;

import com.udea.josukestore.dominio.user.UserRepository;
import com.udea.josukestore.dominio.user.dto.EmployeRegistrationData;
import com.udea.josukestore.dominio.user.dto.UserResgistrationData;
import com.udea.josukestore.infra.exceptions.CustomValidationException;

@Component
public class UserUserNameValidation implements UserValidator {

    private UserRepository userRepository;

    public UserUserNameValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserResgistrationData user) {
        validateUserName(user.userName());
    }

    @Override
    public void validate(EmployeRegistrationData employe) {
        validateUserName(employe.userName());
    }

    private void validateUserName(String userName) {
        if (this.userRepository.existsByUserName(userName)){
            throw new CustomValidationException("userName",
                    "The user name (" + userName + ") is already in use.");
        }
    }
}
