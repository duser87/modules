package ru.innopolis.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.stereotype.Service;
import ru.innopolis.models.DTO.request.PostDTO;
import ru.innopolis.models.DTO.response.PostResponseDTO;
import ru.innopolis.models.Entity.PostEntity;
import ru.innopolis.repositories.JpaPostRepository;
import ru.innopolis.services.PostServiceInterface;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostServiceInterface {

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
