package ru.innopolis.repository;

import ru.innopolis.model.Position;

import java.util.List;

public interface PositionRepository {

    public String create();

    public Position findById(Long id);

    public List<Position> findAll();

    public String update(Long id, String pos);

    public String deleteById(Long id);

    public String deleteAll();

    public Long countById(Long id);

}
