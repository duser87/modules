package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.PatientDTO;
import ru.innopolis.entity.PatientEntity;
import ru.innopolis.repository.JpaPatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final JpaPatientRepository jpaPatientRepository;

    public String create(PatientDTO patientDTO){
        var patient = PatientEntity.builder()
                .fio(patientDTO.getFio())
                .address(patientDTO.getAddress())
                .tel(patientDTO.getTel())
                .build();
        jpaPatientRepository.save(patient);
        return "Добавлен клиент - " + patient.getFio() + ", тел. " + patient.getTel() + ", адрес " + patient.getAddress();
    }

    public String delete(Long id){
        jpaPatientRepository.deleteById(id);
        return "Данные клиента с ID-" + id + " удалены...";
    }

    public PatientDTO findById(Long id){
        var result = jpaPatientRepository.findById(id);
        return PatientDTO.builder()
                .id(result.get().getId())
                .fio(result.get().getFio())
                .tel(result.get().getTel())
                .address(result.get().getAddress())
                .build();
    }
}
