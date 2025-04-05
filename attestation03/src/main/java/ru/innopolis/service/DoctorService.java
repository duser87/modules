package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.DoctorDTO;
import ru.innopolis.entity.DoctorEntity;
import ru.innopolis.repository.JpaDoctorRepository;
import ru.innopolis.repository.JpaPositionRepository;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final JpaDoctorRepository jpaDoctorRepository;
    private final JpaPositionRepository jpaPositionRepository;

    public String create(DoctorDTO doctorDTO){
        var result = jpaPositionRepository.findByPosition(doctorDTO.getPos());
        var doctor = DoctorEntity.builder()
                .fioDoc(doctorDTO.getFioDoc())
                .idPos(result.getId())
                .telDoc(doctorDTO.getTelDoc())
                .build();
        jpaDoctorRepository.save(doctor);
        return "Добавлен врач - " + doctor.getFioDoc() + ", тел. " + doctor.getTelDoc();
    }

    public DoctorDTO findById(Long id){
        var doctor = jpaDoctorRepository.findById(id);
        var position = jpaPositionRepository.findById(doctor.get().getIdPos());
        return DoctorDTO.builder()
                .id(doctor.get().getId())
                .pos(position.get().getPosition())
                .fioDoc(doctor.get().getFioDoc())
                .telDoc(doctor.get().getTelDoc())
                .build();
    }

    public String delete(Long id){
        jpaDoctorRepository.deleteById(id);
        return "Данные работника с ID-" + id + " удалены...";
    }

    public String update(DoctorDTO doctorDTO){
        var doctor = jpaDoctorRepository.findById(doctorDTO.getId());
        var position = jpaPositionRepository.findByPosition(doctorDTO.getPos());
        var result = DoctorEntity.builder()
                .id(doctor.get().getId())
                .fioDoc(doctorDTO.getFioDoc())
                .telDoc(doctorDTO.getTelDoc())
                .idPos(position.getId())
                .build();
        jpaDoctorRepository.save(result);
        return "Запись с ID-" + doctor.get().getId() + " обновлена!";
    }
}
