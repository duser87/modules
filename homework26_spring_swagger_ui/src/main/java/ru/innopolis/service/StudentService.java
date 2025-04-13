package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.StudentDTO;
import ru.innopolis.entity.Student;
import ru.innopolis.repository.JpaStudentRepository;

import java.util.List;

/**
 * Класс service-слоя. Реализующий основную логику программы.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final JpaStudentRepository jpaStudentRepository;

    /**
     * Метод добавления новой записи о студенте в БД.
     * @param dto-объект класса StudentDTO, с необходимыми полями
     * @return Объект класса Student, который был успешно добавлен в БД
     */
    public StudentDTO create(StudentDTO dto){
        var result = Student.builder()
                .age(dto.getAge())
                .email(dto.getEmail())
                .fio(dto.getFio())
                .build();
        jpaStudentRepository.save(result);
        return dto;
    }

    /**
     * Метод удаления записи из БД по id
     * @param id-идентификатор студента
     * @return Возвращает строку, указывающую на успешное удаление записи по ID
     */
    public String delete(Long id){
        jpaStudentRepository.deleteById(id);
        return "Запись с ID - " + id + " удалена!";
    }

    /**
     * Метод получения записи из БД по ID
     * @param id-идентификатор студента
     * @return Объект класса Student
     */
    public StudentDTO findById(Long id){
        var result = jpaStudentRepository.findById(id).orElseThrow();
        return StudentDTO.builder()
                .age(result.getAge())
                .email(result.getEmail())
                .fio(result.getFio())
                .build();
    }

    /**
     * Метод, реализующий операцию обновления данных записи в БД
     * @param dto-объект класса StudentDTO
     * @return Обновленную запись в БД
     */
    public StudentDTO update(StudentDTO dto){
        var result = jpaStudentRepository.findByFio(dto.getFio());
        var student = Student.builder()
                .id(result.getId())
                .fio(dto.getFio())
                .age(dto.getAge())
                .email(dto.getEmail())
                .build();
        jpaStudentRepository.save(student);
        return dto;
    }

    /**
     * Метод получения списка студентов
     * @return список студентов
     */
    public List<Student> getListStudents(){
        return jpaStudentRepository.findAll();
    }
}