package org.attestation_final.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.EmployeeDTO;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.attestation_final.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8081/api/v1/services/employee
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/services/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employee;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param dto - параметр метода, содержащий объект класса EmployeeDTO - описывающий нового работника
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary="Метод создания нового работника в БД", description = "Создание записи о новом работнике в БД")
    @ApiResponse(responseCode = "200", description = "Создание записи о новом работнике")
    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.create(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку PUT-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * для обновления записи в БД
     * @param dto - параметр метода, содержащий объект класса EmployeeDTO- описывающий нового работника
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary = "Метод обновления уже существующей записи работника", description = "Обновление записи работника")
    @ApiResponse(responseCode = "200", description = "Обновление существующей записи о работнике в БД")
    @PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.update(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачном удалении записи из БД
     */
    @Operation(summary = "Метод удаление записи о работнике", description = "Удаление записи о работнике")
    @ApiResponse(responseCode = "200", description = "Удаление записи о работнике из БД")
    @DeleteMapping(value = "/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> delete(@PathVariable("id") Long id){
        EmployeeResponseDTO response = employee.delete(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа EmployeeDTO
     */
    @Operation(summary = "Метод получения объекта записи к врачу из БД", description = "Получение записи к врачу по ID")
    @ApiResponse(responseCode = "200", description = "Получение записи к врачу по ID")
    @GetMapping(value = "/{id}", /* consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> find(@PathVariable("id") Long id){
        EmployeeResponseDTO response = employee.findById(id);
        return ResponseEntity.ok(response);
    }

}
