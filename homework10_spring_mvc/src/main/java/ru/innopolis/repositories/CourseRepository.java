package ru.innopolis.repositories;

import ru.innopolis.models.Course;

public interface CourseRepository {

    public void create();
    public Course update();
    public String delete();
    public Course findById();

}
