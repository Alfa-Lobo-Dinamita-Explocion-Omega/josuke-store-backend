package com.udea.JosukeStore.controller;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.udea.JosukeStore.dominio.user.dto.UserAuthData;
import com.udea.JosukeStore.dominio.user.model.User;
import com.udea.JosukeStore.infra.security.DatosJWttoken;
import com.udea.JosukeStore.infra.security.TokenService;

@RestController
@RequestMapping("/auth/login")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWttoken> autenticarUsuario(@RequestBody @Valid UserAuthData userAuthData ){
        Authentication authToken= new UsernamePasswordAuthenticationToken(userAuthData.userName(),userAuthData.password());
        var userAuhtenticate = authenticationManager.authenticate(authToken);
        var JWttoken = tokenService.makeToken((User) userAuhtenticate.getPrincipal());
        return ResponseEntity.ok(new DatosJWttoken(JWttoken));
    }

}
