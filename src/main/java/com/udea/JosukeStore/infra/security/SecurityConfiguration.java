package com.udea.josukestore.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.udea.josukestore.dominio.user.model.Permission.*;
import static com.udea.josukestore.dominio.user.model.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionAuthenticationStrategy -> sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(rQ -> {
                    rQ.requestMatchers("/products/**").hasAnyRole(ADMIN.name(), EMPLOYE.name());
                    rQ.requestMatchers(GET,"/products/**").hasAnyAuthority(ADMIN_READ.name(), EMPLOYE_READ.name());
                    rQ.requestMatchers(GET, "/customer/products/**").permitAll();
                    rQ.requestMatchers(POST,"/products/**").hasAnyAuthority(ADMIN_CREATE.name(), EMPLOYE_CREATE.name());
                    rQ.requestMatchers(PUT,"/products/**").hasAnyAuthority(ADMIN_UPDATE.name(), EMPLOYE_UPDATE.name());
                    rQ.requestMatchers(DELETE,"/products/**").hasAnyAuthority(ADMIN_DELETE.name());
                    rQ.requestMatchers("/users/**").permitAll();
                    rQ.requestMatchers("/auth/**").permitAll();
                    rQ.requestMatchers("/employe/**").permitAll();
                    rQ.anyRequest().authenticated();
                })
                .cors(Customizer.withDefaults())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    
}
