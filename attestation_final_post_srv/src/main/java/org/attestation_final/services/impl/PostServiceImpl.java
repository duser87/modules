package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.PostDTO;
import org.attestation_final.model.DTO.response.PostResponseDTO;
import org.attestation_final.model.entities.PostEntity;
import org.attestation_final.repositories.JpaPostRepository;
import org.attestation_final.services.IPostService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public PostResponseDTO create(PostDTO dto) {
        PostEntity result = new PostEntity();
        try{
            result = jpaPostRepository.save(PostEntity.builder()
                    .idPos(dto.getIdPost())
                    .idEmpl(dto.getIdEmpl())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PostResponseDTO.builder()
                .id(result.getId())
                .idPos(result.getIdPos())
                .idEmpl(result.getIdEmpl())
                .message(" -> Добавлена связь работника с должностью в БД!")
                .build();
    }

    @Override
    public PostResponseDTO delete(PostDTO dto) {
        PostEntity result = new PostEntity();
        String msg = "";
        try{
            result = jpaPostRepository.findByIdPosAndIdEmpl(dto.getIdPost(), dto.getIdEmpl());
            if(result.getId() != 0L){
                msg = " -> Связь работника с должностью удалена из БД";
            }
            else{
                msg = " -> Такого связи в БД нет";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return PostResponseDTO.builder()
                .id(result.getId())
                .idPos(dto.getIdPost())
                .idEmpl(dto.getIdEmpl())
                .message(msg)
                .build();
    }
}
