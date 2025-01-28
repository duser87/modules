package ru.innopolis.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.innopolis.model.Note;
import ru.innopolis.repository.NoteRepository;

@Service
@Profile("sanbox")
public class NoteServiceSan {
    private final NoteRepository noteRepository;

    public NoteServiceSan(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note){
        noteRepository.create(note.getId(), note.getTopic(), note.getText_notes());
        return noteRepository.findById(note.getId());
    }

    public Note updateNote(Long id, String topic, String text){
        noteRepository.update(id, topic, text);
        return noteRepository.findById(id);
    }

    public String deleteNote(Long id){
        noteRepository.delete(id);
        return "Запись с ID-" + id + " удалена!";
    }

    public Note findNote(Long id){
        return noteRepository.findById(id);
    }
}
