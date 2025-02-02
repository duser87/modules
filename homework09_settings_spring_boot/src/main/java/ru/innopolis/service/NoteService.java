package ru.innopolis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.innopolis.model.Note;
import ru.innopolis.repository.NoteRepositoryInterface;

import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    @Qualifier("noteRepositoryProdImpl")
    private NoteRepositoryInterface noteRepository;


    public Note createNote(Note note){
        noteRepository.create(note.getId(), note.getTopic(), note.getText_notes());
        Optional<Note> result =noteRepository.findById(note.getId());
        return result.orElseThrow();
    }

    public Note updateNote(Long id, String topic, String text){
        noteRepository.update(id, topic, text);
        Optional<Note> result = noteRepository.findById(id);
        return result.orElseThrow();
    }

    public String deleteNote(Long id){
        noteRepository.delete(id);
        return "Запись с ID-" + id + " удалена!";
    }

    public Note findNote(Long id){
        Optional<Note> result = noteRepository.findById(id);
        return result.orElseThrow();
    }
}
