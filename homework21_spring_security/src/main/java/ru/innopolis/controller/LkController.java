package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
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
import ru.innopolis.service.StudentsService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student/lk/")
public class LkController {

    private final RegService regService;
    private final StudentsService studentsService;

    @GetMapping()
    public String getUserAuthenString(){
        log.info("<<<>>> Auth");
        AuthenticateUser authenticateUser = (AuthenticateUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var auth = regService.loadUserByUsername(authenticateUser.getUsername());
        var res = regService.getUserData(auth.getUsername());
        var listCourses = studentsService.getListCoursesStudent(res.getIdStudent());
        return "--->>> Вы вошли как " + (studentsService.findById(res.getIdStudent())).getFio() + ". Вы записаны на следующие курсы: " + listCourses;
    }
}
