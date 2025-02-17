package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.StudentEntity;

@Repository
public interface JpaRepositoryInterface extends JpaRepository<StudentEntity, Long>  {

}
