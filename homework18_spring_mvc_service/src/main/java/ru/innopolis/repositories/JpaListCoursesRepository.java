package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.innopolis.entities.ListCoursesEntity;

import java.util.List;

@Repository
public interface JpaListCoursesRepository extends JpaRepository<ListCoursesEntity, Long> {
    @Query(value = "SELECT lce FROM ListCoursesEntity lce WHERE lce.id_student = :x")
    List<ListCoursesEntity> findListCoursesById(@Param("x") Long id_student);

    @Modifying
    @Query(value = "DELETE FROM ListCoursesEntity lce WHERE lce.id_student = :x AND lce.id_course = :y")
    void deleteByFioAndCourse(@Param("x") Long id_student, @Param("y") Long id_course);
}
