package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.EmployeeEntity;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByFioEmpl(String fioEmpl);
}
