import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.service.NoteServiceProd;

@SpringBootTest(classes={NoteServiceProd.class})
public class NoteServiceTest {

    private NoteServiceProd noteService;

    void noteTextTest(){
        var result = noteService.findNote(1L);
        Assertions.assertEquals("Тема 1", result.getTopic());
    }
}
