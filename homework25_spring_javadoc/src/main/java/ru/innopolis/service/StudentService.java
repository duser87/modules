package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.Student;
import ru.innopolis.repository.JpaStudentRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final JpaStudentRepository jpaStudentRepository;

    public Student create(Student student){
        return jpaStudentRepository.save(student);
    }

    public String delete(Long id){
        jpaStudentRepository.deleteById(id);
        return "Запись с ID - " + id + " удалена!";
    }

    public Student findById(Long id){
        return jpaStudentRepository.findById(id).orElseThrow();
    }

    public Student update(Student student){
        var std = jpaStudentRepository.findById(student.getId());
        return Student.builder()
                .id(std.get().getId())
                .age(std.get().getAge())
                .fio(std.get().getFio())
                .email(std.get().getEmail())
                .build();
    }
}
