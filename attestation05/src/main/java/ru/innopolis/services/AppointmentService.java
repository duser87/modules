package ru.innopolis.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.models.DTO.AppointmentDTO;
import ru.innopolis.models.Entity.AppointmentEntity;
import ru.innopolis.repositories.JpaAppointmentRepository;
import ru.innopolis.repositories.JpaEmployeeRepository;
import ru.innopolis.repositories.JpaPatientRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPatientRepository jpaPatientRepository;

    public String create(AppointmentDTO aDTO){
//        log.info(aDTO.toString());
//        var resAppointment = jpaAppointmentRepository.findByIdEmplAndIdPat(aDTO.getIdEmpl(), aDTO.getIdPat(), aDTO.getTime());
//        log.info(resAppointment.toString());
//        if (resAppointment != null){
//
//        }
//        jpaAppointmentRepository.save(ae);
//        return "Вы записаны к врачу " +  " на " + ae.getTime();
    }

    public AppointmentEntity findById(Long id){
        return jpaAppointmentRepository.findById(id).orElseThrow();
    }

    public String delete(Long id){
        jpaAppointmentRepository.deleteById(id);
        return "Ваша запись к врачу " + " удалена!";
    }

    public String update(AppointmentEntity ae){
        var res = jpaAppointmentRepository.findById(ae.getId()).orElseThrow();
        res.setDescription(ae.getDescription());
        res.setIdEmpl(ae.getIdEmpl());
        res.setIdPac(ae.getIdPac());
        jpaAppointmentRepository.save(res);
        return "Запись с ID-" + ae.getId() + " изменена!";
    }


}
