package org.attestation_final.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.AppointmentDTO;
import org.attestation_final.model.DTO.response.AppointmentResponseDTO;
import org.attestation_final.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8081/api/v1/services/appointment
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/services/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointment;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param dto - параметр метода, содержащий объект класса {@link AppointmentDTO} - описывающий запись к опредленному врачу
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary="Метод создания записи к врачу в БД", description = "Создание новой записи к врачу")
    @ApiResponse(responseCode = "200", description = "Создание записи к врачу")
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointment.create(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку PUT-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * для обновления записи в БД
     * @param dto - параметр метода, содержащий объект класса {@link AppointmentDTO} - описывающий запись к опредленному врачу
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary = "Метод обновления уже существующей записи к врачу", description = "Обновление записи к врачу")
    @ApiResponse(responseCode = "200", description = "Обновление существующей записи в БД")
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> update(@RequestBody AppointmentDTO dto){
        AppointmentResponseDTO response = appointment.update(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачном удалении записи из БД
     */
    @Operation(summary = "Метод удаление записи к врачу", description = "Удаление записи к врачу")
    @ApiResponse(responseCode = "200", description = "Удаление записи к врачу из БД")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> delete(@PathVariable("id") Long id){
        AppointmentResponseDTO response = appointment.delete(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа {@link AppointmentDTO}
     */
    @Operation(summary = "Метод получения объекта записи к врачу из БД", description = "Получение записи к врачу по ID")
    @ApiResponse(responseCode = "200", description = "Получение записи к врачу по ID")
    @GetMapping(value = "/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentResponseDTO> find(@PathVariable("id") Long id){
        AppointmentResponseDTO response = appointment.findById(id);
        return ResponseEntity.ok(response);
    }

}