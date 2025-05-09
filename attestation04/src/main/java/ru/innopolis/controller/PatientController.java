package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.PatientEntity;
import ru.innopolis.service.PatientService;

/**
 * Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/patient
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param pe - параметр метода, содержащий объект класса PatientEntity - описывающий сущность клиента поликлиники
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачной записи в БД
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Метод содания объекта \"Пациент\" в БД", description = "Создание записи о пациенте")
    @ApiResponse(responseCode = "200", description = "Создание записи о пациенте в БД")
    public ResponseEntity<String> addPatient(@RequestBody PatientEntity pe){
        log.info(pe.toString());
        var result = patientService.create(pe);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа PatientEntity
     */
    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Метод получения объекта \"Пациент\" в БД", description = "Создание записи о пациенте")
    @ApiResponse(responseCode = "200", description = "Получение записи о пациенте в БД")
    public ResponseEntity<PatientEntity> findByIdPatient(@PathVariable("id") Long id){
        var result = patientService.findById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку PUT-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param pe - параметр метода, содержащий объект класса PatientEntity - описывающий сущность клиента поликлиники
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачном обновлении записи в БД
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Метод обновления объекта \"Пациент\" в БД", description = "Обновление записи о пациенте")
    @ApiResponse(responseCode = "200", description = "Обновление записи о пациенте в БД")
    public ResponseEntity<String> updatePatient(@RequestBody PatientEntity pe){
        var result = patientService.update(pe);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачном удалении записи из БД
     */
    @DeleteMapping("/{id}")
    @Operation(summary="Метод удаления объекта \"Пациент\" в БД", description = "Удаление записи о пациенте")
    @ApiResponse(responseCode = "200", description = "Удаление записи о пациенте из БД")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id){
        String noteResponse = patientService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
