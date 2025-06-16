package ru.innopolis.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.models.DTO.request.EmployeeDTO;
import ru.innopolis.models.DTO.response.EmployeeResponseDTO;
import ru.innopolis.services.EmployeeServiceInterface;

@Slf4j
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employee;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> delete(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employee.delete(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> find(@PathVariable("id") Long id){
        EmployeeResponseDTO response = employee.findById(id);
        return ResponseEntity.ok(response);
    }

}
