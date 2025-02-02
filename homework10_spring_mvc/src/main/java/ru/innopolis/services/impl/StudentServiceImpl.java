package ru.innopolis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.StudentServiceInterface;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentServiceInterface<Student, String> {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository repository){
        studentRepository = repository;

    }

    @Override
    public Student create(Student student)throws Exception{
        return studentRepository.create(student.getId(), student.getFio(), student.getEmail()).orElseThrow();
    }

    @Override
    public Student update(Student student)throws Exception {
        studentRepository.update(student.getId(), student.getFio(), student.getEmail()).orElseThrow();
        return null;
    }

    @Override
    public String delete(Long id) {
        return studentRepository.delete(id);
    }

    @Override
    public Student findById(Long id) throws Exception{
        return studentRepository.findById(id).orElseThrow();
    }
}
