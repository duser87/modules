package ru.innopolis.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class AuthenticateUser implements UserDetails {

    private final UserRegEntity userRegEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return userRegEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userRegEntity.getUsername();
    }
}
