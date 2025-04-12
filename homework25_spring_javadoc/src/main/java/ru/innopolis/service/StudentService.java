package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.Student;
import ru.innopolis.repository.JpaStudentRepository;

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
     * @param student-объект класса Student, с необходимыми полями
     * @return Объект класса Student, который был успешно добавлен в БД
     */
    public Student create(Student student){
        return jpaStudentRepository.save(student);
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
    public Student findById(Long id){
        return jpaStudentRepository.findById(id).orElseThrow();
    }

    /**
     * Метод, реализующий операцию обновления данных записи в БД
     * @param student-объект класса Student
     * @return Обновленную запись в БД
     */
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
