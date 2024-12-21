package ru.innopolis.repository;

import ru.innopolis.model.Position;

import java.util.List;

public interface PositionRepository {

    public List<Position> allFind();

    public void addPos(Long id,String pos);

    public void update(Long id, String pos);

    public void delete(String pos);

}
