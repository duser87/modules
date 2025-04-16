package ru.innopolis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.dto.UserRegisterDataRequest;
import ru.innopolis.entity.UserRegEntity;
import ru.innopolis.service.RegService;

@Slf4j
@RestController
@RequestMapping("/api/v1/employee/register/lk")
public class RegistrationController {
    @Autowired
    private RegService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegEntity> getLk(@RequestBody UserRegisterDataRequest data){
        log.info("---> Метод getLk:: RegistrationController");
        var result = service.register(data);
        return ResponseEntity.ok(result);
    }
}
