package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.UserRegisterDataRequest;
import ru.innopolis.entity.AuthenticateUser;
import ru.innopolis.entity.UserRegEntity;
import ru.innopolis.repository.JpaUserRegRepository;

@Service
@RequiredArgsConstructor
public class RegService implements UserDetailsService {

    @Autowired
    private JpaUserRegRepository jpaUserRegRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserRegEntity register(UserRegisterDataRequest request){
        var result = UserRegEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .build();
        return jpaUserRegRepository.save(result);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = jpaUserRegRepository.findByUsername(username);
        return new AuthenticateUser(user);
    }

//    public void createUser(UserRegisterDataRequest data){
//                var result = UserRegEntity.builder()
//                .username(data.getUsername())
//                .password(data.getPassword())
//                .build();
//        jpaUserRegRepository.save(result);
//    }
}
