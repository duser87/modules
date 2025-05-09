package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.service.AppointmentService;

/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/appointment
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentsController {

    private final AppointmentService appointmentService;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param ae - параметр метода, содержащий объект класса AppointmentsEntity - описывающий запись к опредленному врачу
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачной записи в БД
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addAppointment(@RequestBody AppointmentsEntity ae){
        log.info(ae.toString());
        var result = appointmentService.create(ae);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа AppointmentsEntity
     */
    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentsEntity> findByIdAppointment(@PathVariable("id") Long id){
        var result = appointmentService.findById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку PUT-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * для обновления записи в БД
     * @param ae - параметр метода, содержащий объект класса AppointmentsEntity - описывающий запись к опредленному врачу
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачном обновлении записи в БД
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAppointment(@RequestBody AppointmentsEntity ae){
        var result = appointmentService.update(ae);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачном удалении записи из БД
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long id){
        String noteResponse = appointmentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
