package org.attestation_final.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PatientDTO;
import org.attestation_final.model.DTO.response.PatientResponseDTO;
import org.attestation_final.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/services/patient
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/services/patient")
public class PatientController {

    @Autowired
    private IPatientService patient;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param dto - параметр метода, содержащий объект класса PatientDTO - описывающий нового клиента
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary="Метод создания записи нового клиента в БД", description = "Создание новой записи о клиенте")
    @ApiResponse(responseCode = "200", description = "Создание записи нового клиента в БД")
    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientDTO dto){
        log.info("--> 1");
        PatientResponseDTO response = patient.create(dto);
        log.info("--> 2");
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку PUT-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * для обновления записи в БД
     * @param dto - параметр метода, содержащий объект класса PatientDTO - описывающий клиента, поля которые необходимо обновить
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачном обновлении в БД
     */
    @Operation(summary = "Метод обновления уже существующей записи о клиенте", description = "Обновление записи о клиенте")
    @ApiResponse(responseCode = "200", description = "Обновление существующей о клиенте в БД")
    @PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> update(@RequestBody PatientDTO dto){
        PatientResponseDTO response = patient.update(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачном удалении записи из БД
     */
    @Operation(summary = "Метод удаление записи о клиенте", description = "Удаление записи о клиенте из БД")
    @ApiResponse(responseCode = "200", description = "Удаление записи к врачу из БД")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> delete(@PathVariable("id") Long id){
        PatientResponseDTO response = patient.delete(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа PatientResponseDTO
     */
    @Operation(summary = "Метод получения объекта записи о клиенте из БД", description = "Получение записи о клиенте по ID")
    @ApiResponse(responseCode = "200", description = "Получение записи о клиенте по ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> find(@PathVariable("id") Long id){
        PatientResponseDTO response = patient.findById(id);
        return ResponseEntity.ok(response);
    }

}