package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.AppointmentsDTO;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.repository.JpaAppointmentRepository;
import ru.innopolis.repository.JpaDoctorRepository;
import ru.innopolis.repository.JpaPatientRepository;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final JpaDoctorRepository jpaDoctorRepository;
    private final JpaPatientRepository jpaPatientRepository;

    public String create(AppointmentsDTO appointmentsDTO){
        var doctor = jpaDoctorRepository.findByFioDoc(appointmentsDTO.getFioDoc());
        var pacient = jpaPatientRepository.findByFio(appointmentsDTO.getFioPac());
        var data = AppointmentsEntity.builder()
                        .idDoc(doctor.getId())
                                .idPac(pacient.getId())
                                        .time(appointmentsDTO.getTime())
                                                .description(appointmentsDTO.getDescription())
                                                        .build();
        jpaAppointmentRepository.save(data);
        return "Вы записаны к врачу " + doctor.getFioDoc() + " на " + appointmentsDTO.getTime();
    }

    public AppointmentsDTO findById(Long id){
        var result = jpaAppointmentRepository.findById(id).orElseThrow();
        var doctor = jpaDoctorRepository.findById(result.getIdDoc());
        var pacient = jpaPatientRepository.findById(result.getIdPac());

        return AppointmentsDTO.builder()
                .id(result.getId())
                .fioDoc(doctor.get().getFioDoc())
                .fioPac(pacient.get().getFio())
                .time(result.getTime())
                .description(result.getDescription())
                .build();
    }

    public String delete(Long id){

        var record = jpaAppointmentRepository.findById(id);
        var doctor = jpaDoctorRepository.findById(record.get().getIdDoc());
        jpaAppointmentRepository.deleteById(id);
        return "Ваша запись к врачу " + doctor.get().getFioDoc() + " на " + record.get().getTime() + " удалена!";
    }

    public String update(AppointmentsDTO appointmentsDTO){
        var doctor = jpaDoctorRepository.findByFioDoc(appointmentsDTO.getFioDoc());
        var pacient = jpaPatientRepository.findByFio(appointmentsDTO.getFioPac());
        var result = AppointmentsEntity.builder()
                .id(appointmentsDTO.getId())
                .idPac(pacient.getId())
                .idDoc(doctor.getId())
                .time(appointmentsDTO.getTime())
                .description(appointmentsDTO.getDescription())
                .build();
        jpaAppointmentRepository.save(result);
        return "Запись с ID-" + appointmentsDTO.getId() + " изменена!";
    }

}
