package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.EmployeeDTO;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.attestation_final.model.entities.EmployeeEntity;
import org.attestation_final.repository.JpaEmployeeRepository;
import org.attestation_final.services.IEmployeeService;
import org.springframework.stereotype.Service;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    /**
     * Метод добавления новой записи о новом работнике в БД
     * @param dto - объект класса EmployeeDTO
     * @return информация о успешном создании записи нового работника в БД. Тип - EmployeeResponseDTO
     */
    @Override
    public EmployeeResponseDTO create(EmployeeDTO dto) {
        EmployeeEntity result = new EmployeeEntity();
        try{
            result = jpaEmployeeRepository.save(EmployeeEntity.builder()
                    .fio(dto.getFio())
                    .tel(dto.getTel())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return EmployeeResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .message(" -> Работник - " + dto.getFio() + " добавлен в базу!")
                .build();
    }

    /**
     * Метод обновления записи работника в БД
     * @param dto - объект класса EmployeeDTO
     * @return информация о успешном обновлении записи нового работника в БД. Тип - EmployeeResponseDTO
     */
    @Override
    public EmployeeResponseDTO update(EmployeeDTO dto) {
        EmployeeEntity result = new EmployeeEntity();
        String msg = "";
        try{
            result = jpaEmployeeRepository.findById(dto.getId()).orElseThrow();
            log.info(result.toString());
            if(result.getId() != 0L){
                result.setFio(dto.getFio());
                result.setTel(dto.getTel());
                jpaEmployeeRepository.save(result);
                msg = " -> Данные работника с ID-" + result.getId() + " обновлены!";
            }
            else{
                msg = " -> Работника с ID-" + result.getId() + " не существует";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return EmployeeResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .message(msg)
                .build();
    }

    /**
     * Метод удаления записи о работнике в БД по id
     * @param id - идентификатор работника в БД, тип Long
     * @return информация о успешном удалении записи работника из БД. Тип - EmployeeResponseDTO
     */
    @Override
    public EmployeeResponseDTO delete(Long id) {
        EmployeeEntity result = new EmployeeEntity();
        String msg = "";
        try{
            result = jpaEmployeeRepository.findById(id).orElseThrow();
            if(result.getId() != 0L){
                jpaEmployeeRepository.deleteById(result.getId());
                msg = " -> Данные работника с ID-" + result.getId() + " удалены!";
            }
            else{
                msg = " -> Работника с ID-" + result.getId() + " не существует";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return EmployeeResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .message(msg)
                .build();
    }

    /**
     * Метод получения записи о работнике из БД
     * @param id - объект класса EmployeeDTO
     * @return информация о работника из БД. Тип - EmployeeResponseDTO
     */
    @Override
    public EmployeeResponseDTO findById(Long id) {
        EmployeeEntity result = new EmployeeEntity();
        String msg = "";
        try {
            result = jpaEmployeeRepository.findById(id).orElseThrow();
            if(result.getId() != 0L){
                msg =" -> Получены данные работника";
            }
            else{
                msg = " -> Работника с ID-" + result.getId() + " не существует";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return EmployeeResponseDTO.builder()
                .id(result.getId())
                .fio(result.getFio())
                .tel(result.getTel())
                .message(msg)
                .build();
    }
}
