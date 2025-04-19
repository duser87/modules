import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.service.StudentService;

@Slf4j
@SpringBootTest(classes = StudentService.class)
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void getStudent(){
        Long idStdTest = 1L;

        var response = studentService.findById(1L);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1000L, response.getId());
    }
}
