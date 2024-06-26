package com.udea.JosukeStore.dominio.user;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.udea.JosukeStore.dominio.user.dto.BasicUserData;
import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;
import com.udea.JosukeStore.dominio.user.model.User;
import com.udea.JosukeStore.dominio.user.validations.UserValidator;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;
import com.udea.JosukeStore.infra.exceptions.DataIntegrityValidationException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private List<UserValidator> validators;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           List<UserValidator> validators) {
        this.userRepository = userRepository;
        this.validators = validators;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserData registerUser(UserResgistrationData userResgistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();
        validators.forEach(v -> {
            try {
                v.validate(userResgistrationData);
            } catch (CustomValidationException e) {
                exceptions.add(e);
            }
        });
        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }
        User user = User.createUser(userResgistrationData, passwordEncoder);
        user = this.userRepository.save(user);
        return new UserData(user);
    }

    @Override
    public BasicUserData getUserData(Long id) {
        return new BasicUserData(this.userRepository.getReferenceById(id));
    }


}
