package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.EmployeeEntity;
import ru.innopolis.repository.JpaEmployeeRepository;
import ru.innopolis.repository.JpaPositionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPositionRepository jpaPositionRepository;

    public String create(EmployeeEntity e){
        jpaEmployeeRepository.save(e);
        return "Добавлен работник - " + e.getFioEmpl() + ", тел. " + e.getTelEmpl();
    }

    public EmployeeEntity findById(Long id){
        return jpaEmployeeRepository.findById(id).orElseThrow();
    }

    public String delete(Long id){
        jpaEmployeeRepository.deleteById(id);
        return "Данные работника с ID-" + id + " удалены...";
    }

    public String update(EmployeeEntity e){
        var res = jpaEmployeeRepository.findById(e.getId()).orElseThrow();
        res.setFioEmpl(e.getFioEmpl());
        res.setTelEmpl(e.getTelEmpl());
        jpaEmployeeRepository.save(res);
        return "Запись с ID-" + e.getId() + " обновлена!";
    }
}
