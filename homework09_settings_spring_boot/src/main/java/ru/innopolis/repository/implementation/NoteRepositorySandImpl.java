package ru.innopolis.repository.implementation;

import org.springframework.stereotype.Repository;
import ru.innopolis.model.Note;
import ru.innopolis.repository.NoteRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepositorySandImpl implements NoteRepositoryInterface {

    List<Note> listNoteTest = new ArrayList<>();

    public NoteRepositorySandImpl(){
        for(int i=0; i<6; i++){
            Note note = new Note();
            note.setId(Long.valueOf(i));
            note.setTopic("Topic sandbox " + i);
            note.setText_notes("Text topic sandbox" + i);
            listNoteTest.add(i, note);
        }
    }

    @Override
    public void create(Long id, String topic, String text) {
        Note note = new Note();
        note.setId(id);
        note.setTopic(topic);
        note.setText_notes(text);
        listNoteTest.add(note);
    }

    @Override
    public void update(Long id, String topic, String text) {
        var note = listNoteTest.get(id.intValue());
        note.setTopic(topic);
        note.setText_notes(text);
        listNoteTest.set(id.intValue(), note);
    }

    @Override
    public void delete(Long id) {
        listNoteTest.remove(id.intValue());
    }

    @Override
    public Optional<Note> findById(Long id) {
        return Optional.of(listNoteTest.get(id.intValue()));
    }
}
