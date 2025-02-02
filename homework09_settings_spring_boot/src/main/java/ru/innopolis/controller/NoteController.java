package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.model.Note;
import ru.innopolis.service.NoteService;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    @Autowired
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> methodCreateNote(@RequestBody Note note){
        Note noteResponse = noteService.createNote(note);
        return ResponseEntity.ok(noteResponse);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> methodUpdateNote(@RequestBody Note note){
        Note noteResponse = noteService.findNote(note.getId());
        noteResponse.setId(note.getId());
        noteResponse.setTopic(note.getTopic());
        noteResponse.setText_notes(note.getText_notes());
        noteService.updateNote(noteResponse.getId(), noteResponse.getTopic(), noteResponse.getText_notes());
        return ResponseEntity.ok(noteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteNote(@PathVariable("id") Long id){
        String noteResponse = noteService.deleteNote(id);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> methodFindByIdNote(@PathVariable("id") Long id){
        Note noteResponse = noteService.findNote(id);
        return ResponseEntity.ok(noteResponse);
    }

}
