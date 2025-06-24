package org.attestation_final.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.models.DTO.request.PatientDTO;
import org.attestation_final.models.DTO.request.PostDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.attestation_final.models.DTO.response.PostResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Класс контроллера, обрабатывающий запросы по URL- localhost:8080/api/v1/main/post
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/main/post")
public class PostController {

    @Autowired
    private IMethodsCRUDService<PostResponseDTO, PostDTO> postService;

    /**
     * Метод реализует обработку POST-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый JSON-объект
     * @param dto - параметр метода, содержащий объект класса PatientDTO - описывающий новую запись о должности
     * @return response - ответ клиентской стороне в виде объекта, содержащего информацию о удачной записи в БД
     */
    @Operation(summary="Метод создания новой записи о должности в БД", description = "Создание записи о новой должности в БД")
    @ApiResponse(responseCode = "200", description = "Создание записи о новой должности в БД")
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostDTO dto){
        PostResponseDTO response = postService.create(dto);
        return ResponseEntity.ok(response);
    }

    /**
     * Метод реализует обработку GET-запросов. Он вызывает методы соответсвующего service-слоя и передаёт туда принятый идентификатор записи,
     * по которому можно получить объект этой записи из БД
     * @param id - идентификатор записи, типа Long
     * @return result - возвращаемый объект из БД типа PostResponseDTO
     */
    @Operation(summary = "Метод получения объекта записи о должности из БД", description = "Получение записи о должности по ID")
    @ApiResponse(responseCode = "200", description = "Получение записи о должности по ID")
    @DeleteMapping(path = "/delete/{id}", /*consumes = MediaType.APPLICATION_JSON_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseDTO> delete(@PathVariable("id") Long id){
        PostResponseDTO response = postService.delete(id);
        return ResponseEntity.ok(response);
    }
}
