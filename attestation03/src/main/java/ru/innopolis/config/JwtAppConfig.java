package ru.innopolis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.innopolis.repository.JpaUserRepository;

@Component
@RequiredArgsConstructor
public class JwtAppConfig {

    private final JpaUserRepository jpaUserRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> jpaUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("--->>> Такого пользователя нет!"));
    }
}
