package ru.innopolis.services;

import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;

public interface StudentServiceInterface {
    StudentResponse createRecord(StudentRequest request) ;
    StudentResponse deleteRecord(StudentRequest request);
    StudentResponse getListRecordStudent(Long id);
}
