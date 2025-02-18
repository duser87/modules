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
import ru.innopolis.controllers.StudentsController;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.repositories.JpaStudentRepository;
import ru.innopolis.services.StudentsService;

import java.util.Optional;

@WebMvcTest(controllers = StudentsController.class)
@ContextConfiguration(classes = StudentsController.class)
public class StudentControllerTest {
    @Autowired
    private StudentsController controller;
    @Qualifier("prod")
    @MockitoBean
    private JpaStudentRepository repository;
    @MockitoBean
    private StudentsService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception{
        StudentEntity student = new StudentEntity();
        Mockito.when(repository.save(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/student")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void update() throws Exception{
        StudentEntity student = new StudentEntity();
        Mockito.when(repository.save(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void findByIdTest() throws Exception{
        StudentEntity student = new StudentEntity();
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(student));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/student/1")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void methodRecordOnCourseTest() throws Exception{
        StudentRequest request = new StudentRequest();
        request.setId(10L);
        request.setId_student(1L);
        request.setId_course(1L);
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentsController.class)).methodRecordOnCourse(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student/add_course")).andExpectAll(MvcResult::getResponse);
    }
}
