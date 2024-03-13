package com.udea.JosukeStore.dominio.user;

import com.udea.JosukeStore.dominio.user.dto.UserData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;
import com.udea.JosukeStore.dominio.user.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceimpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserSeviceimpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserData registerUser(UserResgistrationData userResgistrationData){
        User user= User.createUser(userResgistrationData,passwordEncoder);
        user=this.userRepository.save(user);
        return new UserData(user);
    }


}
