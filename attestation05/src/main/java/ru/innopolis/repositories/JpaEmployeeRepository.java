package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.Entity.EmployeeEntity;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findByFioAndTel(String fio, String tel);
}
