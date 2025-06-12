package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.Entity.PostEntity;

@Repository
public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {
}
