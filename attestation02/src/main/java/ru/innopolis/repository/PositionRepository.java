package ru.innopolis.repository;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionRepository {

    public void create(Long id, String pos) throws ErrorWritingDbById;

    public Optional<Position> findById(Long id);

    public List<Position> findAll();

    public String update(Object id, Object pos) throws IllegalArgumentException;

    public String deleteById(Long id) throws NoRecordRowDB;

    public String deleteAll();

    public Long count();

}
