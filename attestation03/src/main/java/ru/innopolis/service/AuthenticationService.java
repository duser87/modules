package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.AuthenticationRequest;
import ru.innopolis.dto.AuthenticationResponse;
import ru.innopolis.dto.RegisterRequest;
import ru.innopolis.entity.Role;
import ru.innopolis.entity.UserEntity;
import ru.innopolis.repository.JpaPatientRepository;
import ru.innopolis.repository.JpaUserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JpaUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user = UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        jpaUserRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = jpaUserRepository.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user.orElseThrow());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
