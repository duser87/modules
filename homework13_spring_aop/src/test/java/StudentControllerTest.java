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
import ru.innopolis.models.Student;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.StudentsService;

import java.util.Optional;

@WebMvcTest(controllers = StudentsController.class)
@ContextConfiguration(classes = StudentsController.class)
public class StudentControllerTest {

    @Autowired
    private StudentsController controller;
    @Qualifier("prod")
    @MockitoBean
    private StudentRepository repository;
    @MockitoBean
    private StudentsService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findByIdTest() throws Exception{
        Student student = new Student();
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(student));
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
