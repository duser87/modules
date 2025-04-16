package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.UserRegisterDataRequest;
import ru.innopolis.entity.UserRegEntity;
import ru.innopolis.repository.JpaUserRegRepository;
import ru.innopolis.utils.AuthenticateUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegService implements UserDetailsService {

    private final JpaUserRegRepository jpaUserRegRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegEntity register(UserRegisterDataRequest request){
        var result = UserRegEntity.builder()
                .idUsr(request.getIdUsr())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .permit(true)
                .email(request.getEmail())
                .build();
        log.info("--->>> Метод register");
        jpaUserRegRepository.save(result);
        return jpaUserRegRepository.findByUsername(request.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("--->>> LOADUSERBYUSERNAME --->" + username);
        var user = jpaUserRegRepository.findByUsername(username);
        log.info("--->>> Метод loadUserByUsername");
        return new AuthenticateUser(user);
    }

    public UserRegEntity getUserData(String s){
        return jpaUserRegRepository.findByUsername(s);
    }

}
