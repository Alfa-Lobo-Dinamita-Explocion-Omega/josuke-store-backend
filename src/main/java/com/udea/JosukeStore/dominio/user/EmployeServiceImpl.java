package com.udea.JosukeStore.dominio.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.dominio.user.interfaces.EmployeService;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;
import com.udea.JosukeStore.dominio.user.model.User;
import com.udea.JosukeStore.dominio.user.validations.UserValidator;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;
import com.udea.JosukeStore.infra.exceptions.DataIntegrityValidationException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    private UserRepository userRepository;
    private List<UserValidator> validators;
    private PasswordEncoder passwordEncoder;

    public EmployeServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                          List<UserValidator> validators) {
        this.userRepository = userRepository;
        this.validators = validators;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserData registerEmploye(EmployeRegistrationData employeRegistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();
        validators.forEach(v -> {
            try {
                v.validate(employeRegistrationData);
            } catch (CustomValidationException e) {
                exceptions.add(e);
            }
        });
        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }
        User employe = User.createEmploye(employeRegistrationData, passwordEncoder);
        employe = this.userRepository.save(employe);
        return new UserData(employe);
    }
}
