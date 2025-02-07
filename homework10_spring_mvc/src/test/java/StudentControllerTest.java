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

import ru.innopolis.dto.RecordStudentRequest;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.impl.StudentService;

import java.util.Optional;

@WebMvcTest(controllers = StudentController.class)
@ContextConfiguration(classes = StudentController.class)
public class StudentControllerTest {

    @Autowired
    StudentController studentController;

    @MockitoBean
    StudentService service;

    @MockitoBean
    StudentRepository studentRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void studentFindById() throws Exception{
        Student student = new Student();
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/student/1")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void studentCreate() throws Exception{
        Student student = new Student();
        student.setId(10L);
        student.setFio("Дмитриев Дмитрий Дмитриевич");
        student.setEmail("d.dmitriev@test.com");
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentController.class)).methodCreateStudent(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void studentUpdate() throws Exception{
        Student student = new Student();
        student.setId(1L);
        student.setFio("Тестов Тест Тестович");
        student.setEmail("d.test@test.com");
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentController.class)).methodUpdateStudent(student);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/student")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void studentDelete() throws Exception{
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentController.class)).methodDeleteStudent(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/student/1")).andExpectAll(MvcResult::getResponse);
    }

    @Test
    void studentRecordOnCourse()throws Exception{
        RecordStudentRequest request = new RecordStudentRequest();
        request.setId(1L);
        request.setId_student(1L);
        request.setId_course(1L);
        Mockito.doThrow(new RuntimeException()).when(Mockito.mock(StudentController.class)).methodRecordOnCourse(request);
        mockMvc.perform(MockMvcRequestBuilders.put("/add_course")).andExpectAll(MvcResult::getResponse);
    }

}
