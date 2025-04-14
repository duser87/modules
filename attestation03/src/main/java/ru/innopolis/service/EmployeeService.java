package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.EmployeeDTO;
import ru.innopolis.entity.EmployeeEntity;
import ru.innopolis.repository.JpaEmployeeRepository;
import ru.innopolis.repository.JpaPositionRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPositionRepository jpaPositionRepository;

    public String create(EmployeeDTO employeeDTO){
        var result = jpaPositionRepository.findByPosition(employeeDTO.getPos());
        var doctor = EmployeeEntity.builder()
                .fioEmpl(employeeDTO.getFioEmpl())
                .idPos(result.getId())
                .telEmpl(employeeDTO.getTelEmpl())
                .build();
        jpaEmployeeRepository.save(doctor);
        return "Добавлен врач - " + doctor.getFioEmpl() + ", тел. " + doctor.getTelEmpl();
    }

    public EmployeeDTO findById(Long id){
        var doctor = jpaEmployeeRepository.findById(id);
        var position = jpaPositionRepository.findById(doctor.get().getIdPos());
        return EmployeeDTO.builder()
                .id(doctor.get().getId())
                .pos(position.get().getPosition())
                .fioEmpl(doctor.get().getFioEmpl())
                .telEmpl(doctor.get().getTelEmpl())
                .build();
    }

    public String delete(Long id){
        jpaEmployeeRepository.deleteById(id);
        return "Данные работника с ID-" + id + " удалены...";
    }

    public String update(EmployeeDTO employeeDTO){
        var doctor = jpaEmployeeRepository.findById(employeeDTO.getId());
        var position = jpaPositionRepository.findByPosition(employeeDTO.getPos());
        var result = EmployeeEntity.builder()
                .id(doctor.get().getId())
                .fioEmpl(employeeDTO.getFioEmpl())
                .telEmpl(employeeDTO.getTelEmpl())
                .idPos(position.getId())
                .build();
        jpaEmployeeRepository.save(result);
        return "Запись с ID-" + doctor.get().getId() + " обновлена!";
    }
}
