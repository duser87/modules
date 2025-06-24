package org.attestation_final.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.models.DTO.request.PatientDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/main/patient
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/main/patient")
public class PatientController {

    @Autowired
    private IMethodsCRUDService<PatientResponseDTO, PatientDTO> patientService;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param dto - параметр метода, содержащий объект класса PatientDTO - описывающий нового клиента
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary="Метод создания нового клиента в БД", description = "Создание записи о новом клиенте в БД")
    @ApiResponse(responseCode = "200", description = "Создание записи о новом клиенте")
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientDTO dto){
        PatientResponseDTO response = patientService.create(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку PUT-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * для обновления записи в БД
     * @param dto - параметр метода, содержащий объект класса PatientDTO- описывающий запись о клиенте
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачном обновлении записи в БД
     */
    @Operation(summary = "Метод обновления уже существующей записи клиента", description = "Обновление записи клиента")
    @ApiResponse(responseCode = "200", description = "Обновление существующей записи о клиенте в БД")
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> update(@RequestBody PatientDTO dto){
        PatientResponseDTO response = patientService.update(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачном удалении записи из БД
     */
    @Operation(summary = "Метод удаление записи о клиенте", description = "Удаление записи о клиенте")
    @ApiResponse(responseCode = "200", description = "Удаление записи о клиенте из БД")
    @DeleteMapping(path = "/delete/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> delete(@PathVariable("id") Long id){
        PatientResponseDTO response = patientService.delete(id);
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
    @GetMapping(value = "/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponseDTO> find(@PathVariable("id") Long id){
        PatientResponseDTO response = patientService.find(id);
        return ResponseEntity.ok(response);
    }

}
