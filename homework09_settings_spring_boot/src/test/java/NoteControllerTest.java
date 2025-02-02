import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.innopolis.controller.NoteController;
import ru.innopolis.model.Note;
import ru.innopolis.repository.NoteRepositoryInterface;
import ru.innopolis.service.NoteService;

import java.util.Optional;

@WebMvcTest(controllers = NoteController.class)
@ContextConfiguration(classes = NoteController.class)
public class NoteControllerTest {

    @Autowired
    private NoteController noteController;
    @Qualifier("noteRepositoryProdImpl")
    @MockitoBean
    private NoteRepositoryInterface noteRepositoryInterface;
    @MockitoBean
    private NoteService noteService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void noteFindById() throws Exception{
        Note note = new Note();
        Mockito.when(noteRepositoryInterface.findById(2L)).thenReturn(Optional.of(note));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/note/2")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void noteCreate() throws Exception{
        Note note = new Note();
        note.setId(10L);
        note.setTopic("Topic 10");
        note.setText_notes("Bla bla bla 10");
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(NoteController.class)).methodCreateNote(note);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/note")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void noteUpdate() throws Exception{
        Note note = new Note();
        note.setId(1L);
        note.setTopic("Topic 1");
        note.setText_notes("Bla bla bla NEW");
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(NoteController.class)).methodUpdateNote(note);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/note")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void noteDelete() throws Exception{
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(NoteController.class)).methodDeleteNote(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/note/1")).andExpectAll(MvcResult::getResponse);
    }


}
