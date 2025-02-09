package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.repositories.ListCourseRepository;
import ru.innopolis.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository student;
    @Autowired
    private ListCourseRepository listCourse;



}
