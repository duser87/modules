package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.repository.JpaAppointmentRepository;
import ru.innopolis.repository.JpaEmployeeRepository;
import ru.innopolis.repository.JpaPatientRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPatientRepository jpaPatientRepository;

    public String create(AppointmentsEntity ae){
        log.info(ae.toString());
        jpaAppointmentRepository.save(ae);
        return "Вы записаны к врачу " +  " на " + ae.getTime();
    }

    public AppointmentsEntity findById(Long id){
        return jpaAppointmentRepository.findById(id).orElseThrow();
    }

    public String delete(Long id){
        jpaAppointmentRepository.deleteById(id);
        return "Ваша запись к врачу " + " удалена!";
    }

    public String update(AppointmentsEntity ae){
        var res = jpaAppointmentRepository.findById(ae.getId()).orElseThrow();
        res.setDescription(ae.getDescription());
        res.setIdEmpl(ae.getIdEmpl());
        res.setIdPac(ae.getIdPac());
        jpaAppointmentRepository.save(res);
        return "Запись с ID-" + ae.getId() + " изменена!";
    }

}
