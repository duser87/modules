package ru.innopolis.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.models.DTO.request.AppointmentDTO;
import ru.innopolis.models.DTO.response.AppointmentResponseDTO;
import ru.innopolis.models.Entity.AppointmentEntity;
import ru.innopolis.repositories.JpaAppointmentRepository;
import ru.innopolis.repositories.JpaEmployeeRepository;
import ru.innopolis.services.AppointmentServiceInterface;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentServiceInterface {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public AppointmentResponseDTO create(AppointmentDTO dto) {
        AppointmentEntity result = new AppointmentEntity();
        String doctor = "";
        try{
            result = jpaAppointmentRepository.save(AppointmentEntity.builder()
                    .idEmpl(dto.getIdEmpl())
                    .idPat(dto.getIdPat())
                    .time(dto.getTime())
                    .description(dto.getDescription())
                    .del(false)
                    .build());

            doctor = jpaEmployeeRepository.findById(dto.getIdEmpl()).get().getFio();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return AppointmentResponseDTO.builder()
                .id(result.getId())
                .idEmpl(result.getIdEmpl())
                .idPat(result.getIdPat())
                .description(result.getDescription())
                .time(result.getTime())
                .message(" -> Вы записаны к врачу - " + doctor + " на " + dto.getTime()).build();
    }

    @Override
    public AppointmentResponseDTO update(AppointmentDTO dto) {
        AppointmentEntity result = new AppointmentEntity();
        String msg = "";
        try{
            result = jpaAppointmentRepository.findByIdEmplAndIdPat(dto.getIdEmpl(), dto.getIdPat(), dto.getTime());

            if(result.getId() != 0L){
                if(result.getDel().equals(false)){
                    result.setIdEmpl(dto.getIdEmpl());
                    result.setIdPat(dto.getIdPat());
                    result.setTime(dto.getTime());
                    result.setDescription(dto.getDescription());
                    jpaAppointmentRepository.save(result);
                    msg = " -> Данные записи на прием с ID-" + result.getId() + " обновлены!";
                }
                else{
                    msg = " -> Данные записи на прием с ID-" + result.getId() + " невозможно обновить, т.к. запись помечена удаленной в БД!";
                }
            }
            else{
                msg = " -> Такой записи на прием не существует!";
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return AppointmentResponseDTO.builder()
                .id(result.getId())
                .idEmpl(dto.getIdEmpl())
                .idPat(dto.getIdPat())
                .time(dto.getTime())
                .description(dto.getDescription())
                .message(msg)
                .build();
    }

    @Override
    public AppointmentResponseDTO delete(AppointmentDTO dto) {
        AppointmentEntity result = new AppointmentEntity();
        String msg = "";
        try{
            result = jpaAppointmentRepository.findByIdEmplAndIdPat(dto.getIdEmpl(), dto.getIdPat(), dto.getTime());
            if(result.getId() !=  0L){
                //jpaAppointmentRepository.deleteById(result.getId());

                if(result.getDel().equals(false) ){
                    jpaAppointmentRepository.save(AppointmentEntity.builder()
                            .id(result.getId())
                            .idEmpl(result.getIdEmpl())
                            .idPat(result.getIdPat())
                            .time(result.getTime())
                            .description(result.getDescription())
                            .del(true)
                            .build());
                    msg = " -> Запись на прием с ID-" + result.getId() + " удалена!";
                }
                else{
                    msg = " -> Эта запись помечена удаленой!";
                }
            }
            else{
                msg = " -> Записи на прием с ID-" + result.getId() + " не существует...";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return AppointmentResponseDTO.builder()
                .id(result.getId())
                .idEmpl(result.getIdEmpl())
                .idPat(result.getIdPat())
                .time(result.getTime())
                .description(result.getDescription())
                .message(msg)
                .build();
    }

    @Override
    public AppointmentResponseDTO findById(Long id) {
        AppointmentEntity result = new AppointmentEntity();
        String msg = "";
        try{
            result = jpaAppointmentRepository.findById(id).orElseThrow();
            if(result.getId() !=  0L){
                msg = " -> Получена запись на прием с ID-" + result.getId();
            }
            else{
                msg = " -> Записи на прием с ID-" + result.getId() + " не существует...";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return AppointmentResponseDTO.builder()
                .id(result.getId())
                .idEmpl(result.getIdEmpl())
                .idPat(result.getIdPat())
                .time(result.getTime())
                .description(result.getDescription())
                .message(msg)
                .build();
    }
}
