package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.AppointmentsDTO;
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

    public String create(AppointmentsDTO appointmentsDTO){
        var doctor = jpaEmployeeRepository.findByFioEmpl(appointmentsDTO.getFioEmpl());
        var pacient = jpaPatientRepository.findByFio(appointmentsDTO.getFioPac());
        var data = AppointmentsEntity.builder()
                        .idEmpl(doctor.getId())
                                .idPac(pacient.getId())
                                        .time(appointmentsDTO.getTime())
                                                .description(appointmentsDTO.getDescription())
                                                        .build();
        jpaAppointmentRepository.save(data);
        return "Вы записаны к врачу " + doctor.getFioEmpl() + " на " + appointmentsDTO.getTime();
    }

    public AppointmentsDTO findById(Long id){
        var result = jpaAppointmentRepository.findById(id).orElseThrow();
        var doctor = jpaEmployeeRepository.findById(result.getIdEmpl());
        var pacient = jpaPatientRepository.findById(result.getIdPac());

        return AppointmentsDTO.builder()
                .id(result.getId())
                .fioEmpl(doctor.get().getFioEmpl())
                .fioPac(pacient.get().getFio())
                .time(result.getTime())
                .description(result.getDescription())
                .build();
    }

    public String delete(Long id){
        var record = jpaAppointmentRepository.findById(id);
        var doctor = jpaEmployeeRepository.findById(record.get().getIdEmpl());
        jpaAppointmentRepository.deleteById(id);
        return "Ваша запись к врачу " + doctor.get().getFioEmpl() + " на " + record.get().getTime() + " удалена!";
    }

    public String update(AppointmentsDTO appointmentsDTO){
        var doctor = jpaEmployeeRepository.findByFioEmpl(appointmentsDTO.getFioEmpl());
        var pacient = jpaPatientRepository.findByFio(appointmentsDTO.getFioPac());
        var result = AppointmentsEntity.builder()
                .id(appointmentsDTO.getId())
                .idPac(pacient.getId())
                .idEmpl(doctor.getId())
                .time(appointmentsDTO.getTime())
                .description(appointmentsDTO.getDescription())
                .build();
        jpaAppointmentRepository.save(result);
        return "Запись с ID-" + appointmentsDTO.getId() + " изменена!";
    }

}
