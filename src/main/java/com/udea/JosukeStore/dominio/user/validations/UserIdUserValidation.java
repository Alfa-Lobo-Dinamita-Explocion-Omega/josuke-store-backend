package com.udea.JosukeStore.dominio.user.validations;

import org.springframework.stereotype.Component;

import com.udea.JosukeStore.dominio.user.UserRepository;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;

@Component
public class UserIdUserValidation implements UserValidator {

    private UserRepository userRepository;

    public UserIdUserValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserResgistrationData user) {
        if (this.userRepository.existsByIdUser(user.idUser())) {
            throw new CustomValidationException("idUser",
                    "The ID user (" + user.idUser() + ") is already in use.");
        }
    }
}
