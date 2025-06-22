package org.attestation_final.controllers;

import lombok.extern.slf4j.Slf4j;
import org.attestation_final.models.DTO.request.EmployeeDTO;
import org.attestation_final.models.DTO.response.EmployeeResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/main/employee")
public class EmployeeController {

    @Autowired
    private IMethodsCRUDService<EmployeeResponseDTO, EmployeeDTO> employeeService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employeeService.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeDTO dto){
        EmployeeResponseDTO response = employeeService.update(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> delete(@PathVariable("id") Long id){
        EmployeeResponseDTO response = employeeService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> find(@PathVariable("id") Long id){
        EmployeeResponseDTO response = employeeService.find(id);
        return ResponseEntity.ok(response);
    }

}
