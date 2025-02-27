package ru.innopolis.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.innopolis.entities.StudentEntity;

import java.util.List;

@Repository
public interface JpaStudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query(value = "SELECT s FROM StudentEntity s WHERE s.fio = : x")
    StudentEntity findByName(@Param("x") String fio);

    List<StudentEntity> findAll(Specification<StudentEntity> s);

    @Query(value = "SELECT s FROM StudentEntity s, ListCoursesEntity lcs " +
            "WHERE lcs.id_student = s.id AND lcs.id_course = :y and s.age > :x")
    List<StudentEntity> getListStudentByOverOneCourse(@Param("x") Integer age, @Param("y") Long id_course);
}
