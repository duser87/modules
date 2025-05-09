package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.PatientEntity;
import ru.innopolis.repository.JpaPatientRepository;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Service
@RequiredArgsConstructor
public class PatientService {

    private final JpaPatientRepository jpaPatientRepository;

    /**
     * Метод добавления нового клиента в БД
     * @param pe - объект класса PatientEntity
     * @return информация о успешном создании записи нового клиента. Тип - String
     */
    public String create(PatientEntity pe){
        jpaPatientRepository.save(pe);
        return "Добавлен клиент - " + pe.getFio() + ", тел. " + pe.getTel() + ", адрес " + pe.getAddress();
    }

    /**
     * Метод удаления записи о клиенте по id
     * @param id - идентификатор сотрудника
     * @return информация о успешном удалении записи клиента. Тип - String
     */
    public String delete(Long id){
        jpaPatientRepository.deleteById(id);
        return "Данные клиента с ID-" + id + " удалены...";
    }

    /**
     * Метод получения записи о сотруднике по id
     * @param id - идентификатор сотрудника
     * @return объект класса EmployeeEntity
     */
    public PatientEntity findById(Long id){
        return jpaPatientRepository.findById(id).orElseThrow();
    }

    /**
     * Метод обновления записи клиента в БД
     * @param pe - объект класса PatientEntity
     * @return информация о успешном изменении записи клиента. Тип - String
     */
    public String update(PatientEntity pe){
        var res = jpaPatientRepository.findById(pe.getId()).orElseThrow();
        res.setAddress(pe.getAddress());
        res.setFio(pe.getFio());
        res.setTel(pe.getTel());
        jpaPatientRepository.save(res);
        return "Запись с ID-" + pe.getId() + " обновлена!";
    }
}
