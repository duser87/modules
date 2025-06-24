package org.attestation_final.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PostDTO;
import org.attestation_final.model.DTO.response.PostResponseDTO;
import org.attestation_final.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/services/post
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/services/post")
public class PostController {
    @Autowired
    private IPostService post;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param dto - параметр метода, содержащий объект класса PostDTO - описывающий новую должность
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary="Метод создания записи новой должности в БД", description = "Создание новой записи о новой должности")
    @ApiResponse(responseCode = "200", description = "Создание записи новой должности в БД")
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostDTO dto){
        PostResponseDTO response = post.create(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа PositionResponseDTO
     */
    @Operation(summary = "Метод получения объекта записи о должности из БД", description = "Получение записи о должности по ID")
    @ApiResponse(responseCode = "200", description = "Получение записи о должности по ID")
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> delete(@PathVariable("id") Long id){
        PostResponseDTO response = post.delete(id);
        return ResponseEntity.ok(response);
    }
}
