package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.repository.JpaAppointmentRepository;
import ru.innopolis.repository.JpaEmployeeRepository;
import ru.innopolis.repository.JpaPatientRepository;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPatientRepository jpaPatientRepository;

    /**
     * Метод добавления новой записи о приеме в БД
     * @param ae - объект класса AppointmentsEntity
     * @return информация о успешном создании записи на прием к врачу. Тип - String
     */
    public String create(AppointmentsEntity ae){
        log.info(ae.toString());
        jpaAppointmentRepository.save(ae);
        return "Вы записаны к врачу " +  " на " + ae.getTime();
    }

    /**
     * Метод получения записи о приеме к врачу по id
     * @param id - идентификатор записи к врачу
     * @return объект класса AppointmentsEntity
     */
    public AppointmentsEntity findById(Long id){
        return jpaAppointmentRepository.findById(id).orElseThrow();
    }

    /**
     * Метод удаления записи о приеме к врачу по id
     * @param id - идентификатор записи к врачу
     * @return информация о успешном удалении записи на прием к врачу. Тип - String
     */
    public String delete(Long id){
        jpaAppointmentRepository.deleteById(id);
        return "Ваша запись к врачу " + " удалена!";
    }

    /**
     * Метод обновления записи о приеме к врачу
     * @param ae - объект класса AppointmentsEntity
     * @return обновленный объект класса AppointmentsEntity
     */
    public String update(AppointmentsEntity ae){
        var res = jpaAppointmentRepository.findById(ae.getId()).orElseThrow();
        res.setDescription(ae.getDescription());
        res.setIdEmpl(ae.getIdEmpl());
        res.setIdPat(ae.getIdPat());
        jpaAppointmentRepository.save(res);
        return "Запись с ID-" + ae.getId() + " изменена!";
    }

}