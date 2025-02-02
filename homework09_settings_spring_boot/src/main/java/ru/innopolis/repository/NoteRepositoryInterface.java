package ru.innopolis.repository;

import ru.innopolis.model.Note;

import java.util.Optional;

public interface NoteRepositoryInterface {

    public void create(Long id, String topic, String text);
    public void update(Long id, String topic, String text);
    public void delete(Long id);
    public Optional<Note> findById(Long id);

}
