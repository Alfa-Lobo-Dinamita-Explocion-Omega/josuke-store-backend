package com.udea.JosukeStore.dominio.user.validations;

import org.springframework.stereotype.Component;

import com.udea.JosukeStore.dominio.user.UserRepository;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;
@Component
public class UserUserNameValidation implements UserValidator {

    private UserRepository userRepository;

    public UserUserNameValidation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserResgistrationData user) {
        if (this.userRepository.existsByUserName(user.userName())){
            throw new CustomValidationException("userName",
                    "The user name (" + user.userName() + ") is already in use.");
        }
    }
    
}
