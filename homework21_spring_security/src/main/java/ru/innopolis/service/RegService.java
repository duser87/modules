package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.UserRegisterDataRequest;
import ru.innopolis.entity.AuthenticateUser;
import ru.innopolis.entity.CourseEntity;
import ru.innopolis.entity.UserRegEntity;
import ru.innopolis.repository.JpaUserRegRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegService implements UserDetailsService {

    @Autowired
    private JpaUserRegRepository jpaUserRegRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserRegEntity register(UserRegisterDataRequest request){
        var result = UserRegEntity.builder()
                .idStudent(request.getIdStudent())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .build();
        return jpaUserRegRepository.save(result);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("--->>> LOADUSERBYUSERNAME --->" + username);
        var user = jpaUserRegRepository.findByUsername(username);
        log.info("--->>> " + user.toString());
        return new AuthenticateUser(user);
    }

    public UserRegEntity getUserData(String s){
        return jpaUserRegRepository.findByUsername(s);
    }

}
