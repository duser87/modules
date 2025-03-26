package ru.innopolis.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AuthenticateUser implements UserDetails {

    private UserRegEntity userRegEntity;

    public  AuthenticateUser(UserRegEntity e){
        userRegEntity = e;
    }

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
