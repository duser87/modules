package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.TaskEntity;
import ru.innopolis.repository.JpaAuthorityRepository;
import ru.innopolis.repository.JpaRolesRepository;
import ru.innopolis.repository.JpaTaskRepository;
import ru.innopolis.repository.JpaUserRegRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService{

    @Autowired
    private JpaTaskRepository jpaTaskRepository;

    public List<TaskEntity> getListTasks(){
        return jpaTaskRepository.findAll();
    }

    public String createTask(TaskEntity entity){
        jpaTaskRepository.save(entity);
        return "Задача - " + entity.getName() + " добавлена!";
    }

    public void deleteTask(Long id){
        jpaTaskRepository.deleteById(id);
    }
}
