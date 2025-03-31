package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.AuthorityEntity;
import ru.innopolis.entity.RoleEntity;

@Repository
public interface JpaRolesRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
    
}
