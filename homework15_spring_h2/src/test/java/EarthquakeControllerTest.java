import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.innopolis.controller.EarthquakeController;
import ru.innopolis.entity.EarthquakeEntity;
import ru.innopolis.repository.EarthquakeRepository;
import ru.innopolis.service.EarthquakeService;

@WebMvcTest(controllers = EarthquakeController.class)
@ContextConfiguration(classes = EarthquakeController.class)
public class EarthquakeControllerTest {

    @Autowired
    private EarthquakeController controller;

    @MockitoBean
    private EarthquakeRepository repository;
    @MockitoBean
    private EarthquakeService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void add() throws Exception {
        EarthquakeEntity entity = new EarthquakeEntity();
        Mockito.when(repository.save(entity)).thenReturn(entity);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/earthquake")).andExpectAll(MvcResult::getResponse);
    }

}
