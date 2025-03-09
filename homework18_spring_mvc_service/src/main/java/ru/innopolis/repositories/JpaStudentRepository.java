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

    @Query(value = "SELECT s FROM StudentEntity s WHERE s.fio = :fio")
    StudentEntity findByName(@Param("fio") String fio);

    List<StudentEntity> findAll(Specification<StudentEntity> s);

    @Query(value = "SELECT s FROM StudentEntity s, ListCoursesEntity lcs " +
            "WHERE lcs.idStudent = s.id AND lcs.idCourse = :idCourse and s.age > :age")
    List<StudentEntity> getListStudentByOverOneCourse(@Param("age") Integer age, @Param("idCourse") Long idCourse);
}
