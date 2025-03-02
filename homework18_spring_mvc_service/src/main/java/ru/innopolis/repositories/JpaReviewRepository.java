package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.innopolis.entities.ReviewEntity;

import java.util.List;

public interface JpaReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query(value = "SELECT r FROM ReviewEntity r WHERE r.id_student = :id")
    public List<ReviewEntity> findAllByIdStudent(@Param("id") Long idStudent);
}
