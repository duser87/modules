package ru.innopolis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.model.Note;
import ru.innopolis.service.NoteServiceProd;

@RestController
@RequestMapping("/api/v1/note/")
public class NoteController {
    private final NoteServiceProd noteService;

    public NoteController(NoteServiceProd noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> methodCreateNote(@RequestBody Note note){
        Note noteResponse = noteService.createNote(note);
        return ResponseEntity.ok(noteResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<Note> methodUpdateNote(@RequestBody Note note, @PathVariable("id") Long id){
        Note noteResponse = noteService.findNote(id);
        noteResponse.setId(id);
        noteResponse.setTopic(note.getTopic());
        noteResponse.setText_notes(note.getText_notes());
        noteService.updateNote(noteResponse.getId(), noteResponse.getTopic(), noteResponse.getText_notes());
        return ResponseEntity.ok(noteResponse);
    }

    @DeleteMapping
    public ResponseEntity<String> methodDeleteNote(@RequestBody Note note){
        String noteResponse = noteService.deleteNote(note.getId());
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> methodFindByIdNote(@RequestBody Note note, @PathVariable("id") Long id){
        Note noteResponse = noteService.findNote(id);
        return ResponseEntity.ok(noteResponse);
    }

}
