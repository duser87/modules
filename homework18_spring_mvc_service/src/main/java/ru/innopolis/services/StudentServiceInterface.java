package ru.innopolis.services;

import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;

public interface StudentServiceInterface {
    StudentResponse createRecordOnCourse(StudentRequest request) ;
    StudentResponse deleteRecordOnCourse(StudentRequest request);
    StudentResponse getListRecordStudent(Long id);
    StudentResponse findById(Long id);
}