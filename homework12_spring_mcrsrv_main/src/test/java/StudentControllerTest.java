import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.innopolis.controllers.StudentController;
import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;
import ru.innopolis.services.impl.StudentService;

import java.util.Optional;

@WebMvcTest(controllers = StudentController.class)
@ContextConfiguration(classes = StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StudentService service;

    @Test
    void studentRecordOnCourseTest() throws Exception{
        StudentRequest student = new StudentRequest();
        student.setFio("Иванов Иван Иванович");
        student.setId_course(1L);
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentController.class)).createRecordOnCourse(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student/course/add")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void studentDeleteWithCourseTest() throws Exception{
        StudentRequest student = new StudentRequest();
        student.setFio("Иванов Иван Иванович");
        student.setId_course(1L);
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentController.class)).createRecordOnCourse(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student/course/del")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void studentListCoursesFindById() throws Exception{
        StudentResponse response = new StudentResponse();
        Mockito.when(service.getListRecordStudent(1L)).thenReturn(Optional.of(response).orElseThrow());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/student/course/all/1")).andExpectAll(MvcResult::getResponse);
    }

}
