package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.UserRegEntity;

@Repository
public interface JpaUserRegRepository  extends JpaRepository<UserRegEntity, Long> {
    // @Query(value = "SELECT u FROM UserRegEntity u WHERE u.username = :x")
    UserRegEntity findByUsername(String username);

}