package com.udea.josukestore.dominio.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.udea.josukestore.dominio.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByIdUser(Integer idUser);

}
