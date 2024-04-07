package com.udea.JosukeStore.dominio.user.model;


import com.udea.JosukeStore.dominio.user.dto.EmployeRegistrationData;
import com.udea.JosukeStore.dominio.user.dto.UserResgistrationData;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, name = "id_user")
    private Integer idUser;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String department;

    @Column
    private String country;

    @Column(name = "postal_code")
    private String potalCode;

    @Column(unique = true, nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name, String email, String phone, int idUser, String address, String city,String department,String country, String potalCode, String userName, String password, Role role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idUser = idUser;
        this.address = address;
        this.city = city;
        this.department = department;
        this.country = country;
        this.potalCode = potalCode;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public static User createUser(UserResgistrationData userResgistrationData, PasswordEncoder passwordEncoder) {
        String encodedPassword = passwordEncoder.encode(userResgistrationData.password());
        return new User(
                userResgistrationData.name(),
                userResgistrationData.email(),
                userResgistrationData.phone(),
                userResgistrationData.idUser(),
                userResgistrationData.address(),
                userResgistrationData.city(),
                userResgistrationData.department(),
                userResgistrationData.country(),
                userResgistrationData.postalCode(),
                userResgistrationData.userName(),
                encodedPassword,
                Role.CLIENT);
    }

    public static User createEmploye(EmployeRegistrationData employeRegistrationData, PasswordEncoder passwordEncoder) {
        String encodedPassword = passwordEncoder.encode(employeRegistrationData.password());
        return new User(
                employeRegistrationData.name(),
                employeRegistrationData.email(),
                employeRegistrationData.phone(),
                employeRegistrationData.idUser(),
                employeRegistrationData.address(),
                employeRegistrationData.city(),
                employeRegistrationData.department(),
                employeRegistrationData.country(),
                employeRegistrationData.postalCode(),
                employeRegistrationData.userName(),
                encodedPassword,
                employeRegistrationData.role());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
