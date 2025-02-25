package ru.innopolis.client;

import ru.innopolis.dto.courses.CourseResponse;

import java.util.List;

public interface CoursesClient {
    CourseResponse getCourse(Long id);
    List<CourseResponse> getListCourses();
}
