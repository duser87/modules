package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.PositionEntity;
import ru.innopolis.repository.JpaPositionRepository;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Service
@RequiredArgsConstructor
public class PositionService {

    private final JpaPositionRepository jpaPositionRepository;

    /**
     * Метод добавления новой должности в БД
     * @param pe - объект класса PositionEntity
     * @return информация о успешном создании записи новой должности. Тип - String
     */
    public String create(PositionEntity pe){
        jpaPositionRepository.save(pe);
        return "Добавлена должность - " + pe.getPosition();
    }

    /**
     * Метод удаления записи о клиенте по id
     * @param id - идентификатор сотрудника
     * @return информация о успешном удалении записи должности. Тип - String
     */
    public String delete(Long id){
        jpaPositionRepository.deleteById(id);
        return "Данные о должности с ID-" + id + " удалены...";
    }

    /**
     * Метод получения записи о должности по id
     * @param id- идентификатор сотрудника
     * @return объект класса PositionEntity
     */
    public PositionEntity findById(Long id){
        return jpaPositionRepository.findById(id).orElseThrow();
    }

}
