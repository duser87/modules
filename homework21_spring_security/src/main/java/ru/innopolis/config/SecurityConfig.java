package ru.innopolis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

//    private final DataSource dataSource;
//
//    @Bean
//    public JdbcUserDetailsManager user(PasswordEncoder encoder){
//        var manager = new JdbcUserDetailsManager(dataSource);
//        manager.createUser(new User("user1", encoder.encode("123456"), List.of(new SimpleGrantedAuthority("USER"))));
//        return manager;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/lk").hasAuthority("USER")
//                .requestMatchers("api/v1/course/*").permitAll()
//                .requestMatchers("api/v1/course/{id}").permitAll())
////                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return httpSecurity.build();
//    }
//
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( auth -> {
            auth
                    .requestMatchers("api/v1/student/register/lk").permitAll()
                    .requestMatchers("api/v1/student/lk/{id}").permitAll()
                    .anyRequest().authenticated();
        })
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}
