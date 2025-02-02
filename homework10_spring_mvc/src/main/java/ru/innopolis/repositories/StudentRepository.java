package ru.innopolis.repositories;

import org.apache.catalina.LifecycleState;
import ru.innopolis.models.Student;

public interface StudentRepository {

    public void create();
    public Student update();
    public String delete();
    public Student findById();

}
