package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.repository.JpaAppointmentRepository;
import ru.innopolis.repository.JpaEmployeeRepository;
import ru.innopolis.repository.JpaPatientRepository;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final JpaPatientRepository jpaPatientRepository;

    public String create(AppointmentsEntity ae){
        jpaAppointmentRepository.save(ae);
        var res = jpaEmployeeRepository.findById(ae.getIdEmpl());
        return "Вы записаны к врачу " + res.get().getFioEmpl() + " на " + ae.getTime();
    }

    public AppointmentsEntity findById(Long id){
        return jpaAppointmentRepository.findById(id).orElseThrow();
    }

    public String delete(Long id){
        jpaAppointmentRepository.deleteById(id);
        return "Ваша запись к врачу " + " удалена!";
    }

    public String update(AppointmentsEntity ae){
        var res = jpaAppointmentRepository.findById(ae.getId());
        var aeNew = AppointmentsEntity.builder()
                        .id(ae.getId())
                                .idPac(ae.getIdPac())
                                        .idEmpl(ae.getIdEmpl())
                                                .description(ae.getDescription())
                .time(res.get().getTime())
                                                        .build();
        jpaAppointmentRepository.save(aeNew);
        return "Запись с ID-" + ae.getId() + " изменена!";
    }

}
