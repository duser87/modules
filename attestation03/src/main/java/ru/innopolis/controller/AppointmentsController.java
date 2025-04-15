package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.service.AppointmentService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentsController {

    private final AppointmentService appointmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addAppointment(@Valid @RequestBody AppointmentsEntity ae){
        log.info(ae.toString());
        var result = appointmentService.create(ae);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentsEntity> findByIdAppointment(@PathVariable("id") Long id){
        var result = appointmentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAppointment(@Valid @RequestBody AppointmentsEntity ae){
        var result = appointmentService.update(ae);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long id){
        String noteResponse = appointmentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
