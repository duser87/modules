package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.ReviewEntity;

import java.util.List;

@Repository
public interface JpaReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query(value = "SELECT r FROM ReviewEntity r WHERE r.idStudent = :x")
    public List<ReviewEntity> findAllByIdStudent(@Param("x") Long idStudent);
}