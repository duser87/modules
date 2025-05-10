package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.PositionEntity;
import ru.innopolis.service.PositionService;

/**
 * Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/position
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

    private final PositionService positionService;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param pe- параметр метода, содержащий объект класса PositionEntity - описывающий сущность должность работника поликлиники
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачной записи в БД
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Метод содания объекта \"Должность\" в БД", description = "Создание записи о должности")
    @ApiResponse(responseCode = "200", description = "Создание записи о должности в БД")
    public ResponseEntity<String> addPosition(@RequestBody PositionEntity pe){
        log.info(pe.toString());
        var result = positionService.create(pe);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод реализует обработку DELETE-запросов. Он вызывает методы соответсвующего service-слоя для удаления записи из БД по id
     * @param id - идентификатор записи, типа Long
     * @return result - ответ клиентской стороне в виде строки, содержащей информацию о удачном удалении записи из БД
     */
    @DeleteMapping("/{id}")
    @Operation(summary="Метод удаления объекта \"Должность\" в БД", description = "Удаление записи о должности")
    @ApiResponse(responseCode = "200", description = "Удаление записи о должности из БД")
    public ResponseEntity<String> deletePosition(@PathVariable("id") Long id){
        String response = positionService.delete(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа PositionEntity
     */
    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Метод получения объекта \"Должность\" в БД", description = "Получение записи о должности")
    @ApiResponse(responseCode = "200", description = "Получение записи о должности из БД")
    public ResponseEntity<PositionEntity> findByIdPosition(@PathVariable("id") Long id){
        var result = positionService.findById(id);
        return ResponseEntity.ok(result);
    }

}
