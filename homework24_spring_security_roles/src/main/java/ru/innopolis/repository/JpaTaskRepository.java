package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.RoleEntity;
import ru.innopolis.entity.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity findByName(String name);
}
