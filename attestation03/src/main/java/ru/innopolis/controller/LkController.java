package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.service.EmployeeService;
import ru.innopolis.service.RegService;
import ru.innopolis.utils.AuthenticateUser;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee/lk/")
public class LkController {

    private final RegService regService;
    private final EmployeeService employeeService;

    @GetMapping()
    public String getUserAuthenString(){
        log.info("<<<>>> Auth");
        AuthenticateUser authenticateUser = (AuthenticateUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var auth = regService.loadUserByUsername(authenticateUser.getUsername());
        var res = regService.getUserData(auth.getUsername());
        return "--->>> Вы вошли как " + (employeeService.findById(res.getIdUsr())).getFioEmpl();
    }
}
