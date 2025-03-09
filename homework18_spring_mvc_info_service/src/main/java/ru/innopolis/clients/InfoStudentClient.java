package ru.innopolis.clients;

import ru.innopolis.dto.ListCoursesStudentResponse;
import ru.innopolis.dto.StudentResponse;

import java.util.List;

public interface InfoStudentClient {
    List<StudentResponse> getListStudent();
    List<ListCoursesStudentResponse> getListCoursesStudent();
}
