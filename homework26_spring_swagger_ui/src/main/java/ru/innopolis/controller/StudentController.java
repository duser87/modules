package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.StudentDTO;
import ru.innopolis.entity.Student;
import ru.innopolis.service.StudentService;

import java.util.List;

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
     * @param dto Это параметр метода, содержащий объект класса StudentDTO
     * @return result Сохраненный в БД объект типа Student, возвращаемый клиенту
     */
    @Operation(summary="Метод создания записи в БД о студенте", description = "Создание нового пользователя")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO dto){
        var result = studentService.create(dto);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку PUT-запросов. Вызывает методы service-слоя для обновления данных.
     * @param std Это параметр метода, содержащий объект класса StudentDTO
     * @return result Обновленный в БД объект типа Student, возвращаемый клиенту
     */
    @Operation(description = "Обновление данных уже существующего пользователя")
    @ApiResponse(responseCode = "200", description = "Данные пользователя обновлены")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO std){
        var result = studentService.update(std);
        return ResponseEntity.ok(result);
    }

    /**
     * Методы получения данных их БД по ID
     * @param id Идентификатор студаента
     * @return result- объект ответа
     */
    @Operation(description = "Получение данных пользователя по ID")
    @ApiResponse(responseCode = "200", description = "Получены данные пользователя по ID")
    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> findByIdStudent(@PathVariable("id") Long id){
        var result = studentService.findById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Вызывает методы service-слоя для удаления данных по ID.
     * @param id Идентификатор студаента
     * @return Описание удаленной записи о студенте из БД
     */
    @Operation(description = "Удаление пользователя из БД по ID")
    @ApiResponse(responseCode = "200", description = "Пользователь удален")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        String noteResponse = studentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }

    /**
     * Метод получения списка студентов
     * @return Список студентов
     */
    @Operation(description = "Получения списка студентов")
    @ApiResponse(responseCode = "200", description = "Получен список студентов")
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getListStudents(){
        return ResponseEntity.ok(studentService.getListStudents());
    }
}
