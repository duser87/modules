package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.UserRegisterDataRequest;
import ru.innopolis.dto.UserRegisterDataResponse;
import ru.innopolis.entity.AuthenticateUser;
import ru.innopolis.entity.AuthorityEntity;
import ru.innopolis.entity.RoleEntity;
import ru.innopolis.entity.UserRegEntity;
import ru.innopolis.repository.JpaAuthorityRepository;
import ru.innopolis.repository.JpaRolesRepository;
import ru.innopolis.repository.JpaUserRegRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegService implements UserDetailsService {

    @Autowired
    private JpaUserRegRepository jpaUserRegRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JpaRolesRepository jpaRolesRepository;

    public UserRegisterDataResponse register(UserRegisterDataRequest request){

        var result = UserRegEntity.builder()
                .idStudent(request.getIdStudent())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var ur = jpaUserRegRepository.save(result);

//        var auth = AuthorityEntity.builder()
//                .username(request.getUsername())
//                .authority(request.getRole())
//                .build();
//        jpaAuthorityRepository.save(auth);

        var role = RoleEntity.builder().name(request.getRole()).username(request.getUsername()).build();
        jpaRolesRepository.save(role);

        return UserRegisterDataResponse.builder()
                .role(request.getRole())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .idStudent(ur.getIdStudent())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = jpaUserRegRepository.findByUsername(username);
//        log.info("--->>> loadUserByUsername" );
//        List<GrantedAuthority> auth = roles.stream().map(r -> (GrantedAuthority) new SimpleGrantedAuthority(r.getName())).toList();
//        log.info("--->>> loadUserByUsername->" + auth);
//        auth.addAll(roles.stream().map(r -> (GrantedAuthority) new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList()));
//        log.info("--->>> loadUserByUsername->" + auth);

        log.info("--->>> loadUserByUsername" );
//        List<GrantedAuthority> auth = new ArrayList<>();
//        auth.add((GrantedAuthority) new SimpleGrantedAuthority(roles.getName()));
        log.info("--->>> loadUserByUsername->" + user);
        return new AuthenticateUser(user);
    }

    public UserRegEntity getUserData(String s){
        return jpaUserRegRepository.findByUsername(s);
    }

}