package ru.innopolis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.UserRegisterDataRequest;
import ru.innopolis.dto.UserRegisterDataResponse;
import ru.innopolis.entity.AuthenticateUser;
import ru.innopolis.entity.TaskEntity;
import ru.innopolis.service.RegService;
import ru.innopolis.service.TaskService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskEntity>> getRecord(){
        log.info("--->>> Start TasksController GET");
        var result = taskService.getListTasks();
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createRecord(@RequestBody TaskEntity taskEntity){
        log.info("--->>> Start TasksController POST");
        var result = taskService.createTask(taskEntity);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable("id") Long id){
        log.info("--->>> Start TasksController DELETE");
        taskService.deleteTask(id);
        return ResponseEntity.ok("Задача с id-" + id + " удалена!");
    }
}
