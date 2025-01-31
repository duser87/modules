import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.model.Note;
import ru.innopolis.repository.implementation.NoteRepositoryProdImpl;
import ru.innopolis.service.NoteService;

@SpringBootTest(classes={NoteService.class, NoteRepositoryProdImpl.class})
public class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Test
    void noteTopicTest(){
        Note result = noteService.findNote(1L);
        Assertions.assertEquals("Topic 1", result.getTopic());
    }

    @Test
    void noteTextTopicTest(){
        Note note = new Note();
        note.setId(6L);
        note.setTopic("Topic 6");
        note.setText_notes("Text topic 6");
        noteService.createNote(note);
        var res = noteService.findNote(note.getId());
        Assertions.assertEquals("Topic 6", res.getTopic());
    }
}
