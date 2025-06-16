package ru.innopolis.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.models.DTO.request.EmployeeDTO;
import ru.innopolis.models.DTO.response.EmployeeResponseDTO;
import ru.innopolis.models.Entity.EmployeeEntity;
import ru.innopolis.repositories.JpaEmployeeRepository;
import ru.innopolis.services.EmployeeServiceInterface;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private final JpaEmployeeRepository jpaEmployeeRepository;

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
                .fio(result.getFio())
                .tel(result.getTel())
                .message(" -> Работник - " + dto.getFio() + " добавлен в базу!")
                .build();
    }

    @Override
    public EmployeeResponseDTO update(EmployeeDTO dto) {
        EmployeeEntity result = new EmployeeEntity();
        String msg = "";
        try{
            result = jpaEmployeeRepository.findByFioAndTel(dto.getFio(), dto.getTel());
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

    @Override
    public EmployeeResponseDTO delete(EmployeeDTO dto) {
        EmployeeEntity result = new EmployeeEntity();
        String msg = "";
        try{
            result = jpaEmployeeRepository.findByFioAndTel(dto.getFio(), dto.getTel());
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
