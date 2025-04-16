package ru.innopolis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.entity.PatientEntity;
import ru.innopolis.repository.JpaPatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final JpaPatientRepository jpaPatientRepository;

    public String create(PatientEntity pe){
        jpaPatientRepository.save(pe);
        return "Добавлен клиент - " + pe.getFio() + ", тел. " + pe.getTel() + ", адрес " + pe.getAddress();
    }

    public String delete(Long id){
        jpaPatientRepository.deleteById(id);
        return "Данные клиента с ID-" + id + " удалены...";
    }

    public PatientEntity findById(Long id){
        return jpaPatientRepository.findById(id).orElseThrow();
    }

    public String update(PatientEntity pe){
        var res = jpaPatientRepository.findById(pe.getId()).orElseThrow();
        res.setAddress(pe.getAddress());
        res.setFio(pe.getFio());
        res.setTel(pe.getTel());
        jpaPatientRepository.save(res);
        return "Запись с ID-" + pe.getId() + " обновлена!";
    }
}
