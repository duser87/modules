package ru.innopolis.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.models.DTO.request.PatientDTO;
import ru.innopolis.models.DTO.response.PatientResponseDTO;
import ru.innopolis.models.Entity.PatientEntity;
import ru.innopolis.repositories.JpaPatientRepository;
import ru.innopolis.services.PatientServiceInterface;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientServiceInterface {

    private final JpaPatientRepository jpaPatientRepository;

    @Override
    public PatientResponseDTO create(PatientDTO dto) {
        PatientEntity result = new PatientEntity();
        String msg = "";
        try{
            result = jpaPatientRepository.save(PatientEntity.builder()
                    .fio(dto.getFio())
                    .tel(dto.getTel())
                    .address(dto.getAddress())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PatientResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .address(result.getAddress())
                .message(" -> Клиент - " + dto.getFio() + " добавлен в базу!")
                .build();
    }

    @Override
    public PatientResponseDTO update(PatientDTO dto) {
        PatientEntity result = new PatientEntity();
        String msg = "";
        try{
            result = jpaPatientRepository.findByFioAndTel(dto.getFio(), dto.getTel());
            if(result.getId() != 0L){
                jpaPatientRepository.save(PatientEntity.builder()
                        .id(result.getId())
                        .fio(result.getFio())
                        .tel(result.getTel())
                        .address(result.getAddress())
                        .build());
                msg = "-> Данные клиента с ID-" + result.getId() + " обновлены!";
            }
            else{
                msg = "-> Клиента с ID-" + result.getId() + " не существует";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PatientResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .address(result.getAddress())
                .message(msg)
                .build();
    }

    @Override
    public PatientResponseDTO delete(PatientDTO dto) {
        PatientEntity result = new PatientEntity();
        String msg = "";
        try {
            result = jpaPatientRepository.findByFioAndTel(dto.getFio(), dto.getTel());
            if(result.getId() != 0L){
                jpaPatientRepository.deleteById(result.getId());
                msg = "-> Данные клиента с ID-" + result.getId() + " удалены!";
            }
            else{
                msg = "-> Клиента с ID-" + result.getId() + " не существует";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PatientResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .address(result.getAddress())
                .message(msg)
                .build();
    }

    @Override
    public PatientResponseDTO findById(Long id) {
        PatientEntity result = new PatientEntity();
        String msg = "";
        try{
            result = jpaPatientRepository.findById(id).orElseThrow();
            if(result.getId() != 0L){
                msg =" -> Получены данные клиента";
            }
            else{
                msg = " -> Клиента с ID-" + result.getId() + " не существует";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PatientResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .address(result.getAddress())
                .message(msg)
                .build();
    }
}
