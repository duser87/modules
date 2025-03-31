package ru.innopolis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y, 15);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( auth -> {
                    auth
                            .requestMatchers("api/v1/student/register/lk").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/v1/tasks").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/v1/tasks/").hasAnyRole( "USER", "ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/api/v1/tasks/{id}").hasRole("ADMIN")
                            //.requestMatchers("api/v1/student/lk/").permitAll()
                            .anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}