package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.model.DTO.request.AppointmentDTO;
import org.attestation_final.model.DTO.response.AppointmentResponseDTO;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.attestation_final.model.DTO.response.PatientResponseDTO;
import org.attestation_final.model.entities.AppointmentEntity;
import org.attestation_final.repositories.JpaAppointmentRepository;
import org.attestation_final.services.IAppointmentService;
import org.attestation_final.services.IKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentServiceImpl implements IAppointmentService {

    private final JpaAppointmentRepository jpaAppointmentRepository;
    private final IMethodsCRUDRest<EmployeeResponseDTO> restEmployee;
    private final IMethodsCRUDRest<PatientResponseDTO> restPatient;
    private final IKafkaProducer producer;

    /**
     * Метод добавления новой записи о приеме в БД
     * @param dto - объект класса AppointmentDTO
     * @return информация о успешном создании записи на прием к врачу. Тип - AppointmentResponseDTO
     */
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

            var emplResponse = restEmployee.findByIdREST(dto.getIdEmpl());
            var patResponse = restPatient.findByIdREST(dto.getIdPat());

            if(emplResponse.getId() != 0L & patResponse.getId() != 0L){
                String msg = " Здравствуйте! Вы записаны к врачу " + emplResponse.getFio() + " на " + dto.getTime() + ". Тел для отправки уведомления: " + patResponse.getTel();
                producer.sendMessage(msg);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return AppointmentResponseDTO.builder()
                .id(result.getId())
                .idEmpl(result.getIdEmpl())
                .idPat(result.getIdPat())
                .description(result.getDescription())
                .time(result.getTime())
                .message(" -> Вы записаны к врачу - на " + dto.getTime()).build();
    }

    /**
     * Метод обновления записи о приеме к врачу
     * @param dto - объект класса AppointmentDTO
     * @return обновленный объект класса AppointmentResponseDTO
     */
    @Override
    public AppointmentResponseDTO update(AppointmentDTO dto) {
        AppointmentEntity result = new AppointmentEntity();
        String msg = "";
        try {
            result = jpaAppointmentRepository.findByIdEmplAndIdPat(dto.getIdEmpl(), dto.getIdPat());

            if (result.getId() != 0L) {
                if (result.getDel().equals(false)) {
                    result.setIdEmpl(dto.getIdEmpl());
                    result.setIdPat(dto.getIdPat());
                    result.setTime(dto.getTime());
                    result.setDescription(dto.getDescription());
                    jpaAppointmentRepository.save(result);
                    msg = " -> Данные записи на прием с ID-" + result.getId() + " обновлены!";
                } else {
                    msg = " -> Данные записи на прием с ID-" + result.getId() + " невозможно обновить, т.к. запись помечена удаленной в БД!";
                }
            } else {
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
    public AppointmentResponseDTO delete(Long id) {
        AppointmentEntity result = new AppointmentEntity();
        String msg = "";
        try{
            result = jpaAppointmentRepository.findById(id).orElseThrow();
            if(result.getId() !=  0L){
                if(result.getDel().equals(false) ){
                    result.setDel(true);
                    jpaAppointmentRepository.save(result);
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
