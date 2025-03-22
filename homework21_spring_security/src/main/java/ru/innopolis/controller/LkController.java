package ru.innopolis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.entity.AuthenticateUser;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.service.RegService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/lk/")
public class LkController {

    @GetMapping(value = "auth")
    public String getUserAuthen(){
        AuthenticateUser authenticateUser = (AuthenticateUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Привет " + authenticateUser.getUsername() + "! Добро пожаловать! ";
    }
}
