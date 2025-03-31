package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.AuthorityEntity;

@Repository
public interface JpaAuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
    AuthorityEntity findByUsername(String str);
}
