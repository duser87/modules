import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.innopolis.client.CoursesClient;
import ru.innopolis.client.impl.CoursesRestClientImpl;
import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;
import ru.innopolis.repositories.ListCourseRepository;
import ru.innopolis.repositories.impl.ListCourseRepoImpl;
import ru.innopolis.repositories.impl.StudentRepoImpl;
import ru.innopolis.services.impl.StudentService;

@SpringBootTest(classes={StudentService.class, StudentRepoImpl.class})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @MockitoBean
    private ListCourseRepoImpl listCourseRepo;
    @MockitoBean
    private CoursesRestClientImpl client;

    @Test
    void createRecordTest(){
        StudentRequest request =new StudentRequest();
        request.setId_course(1L);
        request.setFio("Иванов Иван Иванович");
        StudentResponse result = studentService.createRecord(request);
        Assertions.assertEquals("Иванов Иван Иванович", result.getName());
    }

    @Test
    void deleteRecordTest(){
        StudentRequest request =new StudentRequest();
        request.setId_course(1L);
        request.setFio("Иванов Иван Иванович");
        StudentResponse result = studentService.deleteRecord(request);
        Assertions.assertEquals(" ---> Запись с данного курса удалена.", result.getMessage());
    }

}
