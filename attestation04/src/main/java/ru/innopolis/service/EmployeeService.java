package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.EmployeeEntity;
import ru.innopolis.repository.JpaEmployeeRepository;
import ru.innopolis.repository.JpaPositionRepository;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPositionRepository jpaPositionRepository;

    /**
     * Метод добавления нового сотрудника в БД
     * @param e - объект класса EmployeeEntity
     * @return информация о успешном создании записи нового сотрудника. Тип - String
     */
    public String create(EmployeeEntity e){
        jpaEmployeeRepository.save(e);
        return "Добавлен работник - " + e.getFioEmpl() + ", тел. " + e.getTelEmpl();
    }

    /**
     * Метод получения записи о сотруднике по id
     * @param id - идентификатор сотрудника
     * @return - объект класса EmployeeEntity
     */
    public EmployeeEntity findById(Long id){
        return jpaEmployeeRepository.findById(id).orElseThrow();
    }

    /**
     * Метод удаления записи о сотруднике по id
     * @param id- идентификатор сотрудника
     * @return информация о успешном удалении записи сотрудника. Тип - String
     */
    public String delete(Long id){
        jpaEmployeeRepository.deleteById(id);
        return "Данные работника с ID-" + id + " удалены...";
    }

    /**
     * Метод обновления записи сотрудника в БД
     * @param e - объект класса EmployeeEntity
     * @return информация о успешном изменении записи сотрудника. Тип - String
     */
    public String update(EmployeeEntity e){
        var res = jpaEmployeeRepository.findById(e.getId()).orElseThrow();
        res.setFioEmpl(e.getFioEmpl());
        res.setTelEmpl(e.getTelEmpl());
        jpaEmployeeRepository.save(res);
        return "Запись с ID-" + e.getId() + " обновлена!";
    }
}
