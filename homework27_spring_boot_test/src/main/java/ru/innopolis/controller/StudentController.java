package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.Student;
import ru.innopolis.service.StudentService;

/**
 *  Класс контроллера для работы с сущностью Student
 * @author Шумилов С.П.
 * @version v_1.0
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {

    private final StudentService studentService;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый объект.
     * @param std Это параметр метода, содержащий объект класса Student
     * @return result Сохраненный в БД объект типа Student, возвращаемый клиенту
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodCreateStudent(@RequestBody Student std){
        var result = studentService.create(std);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку PUT-запросов. Вызывает методы service-слоя для обновления данных.
     * @param std Это параметр метода, содержащий объект класса Student
     * @return result Обновленный в БД объект типа Student, возвращаемый клиенту
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodUpdateStudent( @RequestBody Student std){
        var result = studentService.update(std);
        return ResponseEntity.ok(result);
    }

    /**
     * Методы получения данных их БД по ID
     * @param id Идентификатор студаента
     * @return result- объект ответа
     */
    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodFindByIdStudent(@PathVariable("id") Long id){
        var result = studentService.findById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Вызывает методы service-слоя для удаления данных по ID.
     * @param id Идентификатор студаента
     * @return Описание удаленной записи о студенте из БД
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id){
        String noteResponse = studentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}