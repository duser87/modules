package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PatientDTO;
import org.attestation_final.model.DTO.response.PatientResponseDTO;
import org.attestation_final.model.entities.PatientEntity;
import org.attestation_final.repositories.JpaPatientRepository;
import org.attestation_final.services.IPatientService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final JpaPatientRepository jpaPatientRepository;

    /**
     * Метод добавления новой записи о пациенте в БД
     * @param dto - объект класса AppointmentDTO
     * @return информация о успешном создании записи о новом пациенте. Тип - PatientResponseDTO
     */
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
            log.info(result.toString());
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

    /**
     * Метод обновления записи клиента в БД
     * @param dto - объект класса PatientDTO
     * @return обновленный объект класса PatientResponseDTO
     */
    @Override
    @CachePut(value = "patient-data", key = "#dto.id")
    public PatientResponseDTO update(PatientDTO dto) {
        PatientEntity result = new PatientEntity();
        String msg = "";
        try{
            result = jpaPatientRepository.findById(dto.getId()).orElseThrow();
            if(result.getId() != 0L){
                result.setFio(dto.getFio());
                result.setTel(dto.getTel());
                result.setAddress(dto.getAddress());
                jpaPatientRepository.save(result);
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

    /**
     * Метод удаления записи о клиенте в БД по id
     * @param id - идентификатор
     * @return объект PatientResponseDTO, содержащий информацию о удалении записи в БД
     */
    @Override
    @CacheEvict(value = "patient-data", key = "#id")
    public PatientResponseDTO delete(Long id) {
        PatientEntity result = new PatientEntity();
        String msg = "";
        try {
            result = jpaPatientRepository.findById(id).orElseThrow();
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

    /**
     * Метод получения записи о клиенте из БД по id
     * @param id - идентификатор
     * @return объект PatientResponseDTO, содержащий информацию о получении записи из БД
     */
    @Override
    @Cacheable(value = "patient-data", key = "#id")
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