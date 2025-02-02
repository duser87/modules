package ru.innopolis.repositories;

import ru.innopolis.models.Course;
import ru.innopolis.models.ListCourses;

import java.util.HashMap;
import java.util.List;

public interface ListCoursesRepository {

    public void create();
    public ListCourses update();
    public String delete();
    public ListCourses findById();
    public HashMap<String, String> findByIdList();

}
