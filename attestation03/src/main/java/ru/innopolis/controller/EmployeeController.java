package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.EmployeeDTO;
import ru.innopolis.service.EmployeeService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDoctor(@Valid @RequestBody EmployeeDTO dto){
        log.info(dto.toString());
        var result = employeeService.create(dto);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> findByIdDoctor(@PathVariable("id") Long id){
        var result = employeeService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDoctor(@Valid @RequestBody EmployeeDTO dto){
        var result = employeeService.update(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id){
        String noteResponse = employeeService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
