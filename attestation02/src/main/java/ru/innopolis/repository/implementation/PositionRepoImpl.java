package ru.innopolis.repository.implementation;

import ru.innopolis.model.Position;
import ru.innopolis.repository.PositionRepository;

import java.util.List;

public class PositionRepoImpl implements PositionRepository {
    @Override
    public String create() {
        return "";
    }

    @Override
    public Position findById(Long id) {
        return null;
    }

    @Override
    public List<Position> findAll() {
        return List.of();
    }

    @Override
    public String update(Long id, String pos) {
        return "";
    }

    @Override
    public String deleteById(Long id) {
        return "";
    }

    @Override
    public String deleteAll() {
        return "";
    }

    @Override
    public Long countById(Long id) {
        return 0L;
    }
}
