import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.innopolis.model.Note;
import ru.innopolis.repository.implementation.NoteRepositoryProdImpl;
import ru.innopolis.service.NoteService;

@SpringBootTest(classes={NoteService.class, NoteRepositoryProdImpl.class})
public class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @Test
    void noteTopicTest(){
        Note result = noteService.findNote(2L);
        Assertions.assertEquals("Тема 2", result.getTopic());
    }

    @Test
    void noteTextTopicTest(){
        Note res = noteService.findNote(7L);
        Assertions.assertEquals("Text topic 6", res.getText_notes());
    }
}
