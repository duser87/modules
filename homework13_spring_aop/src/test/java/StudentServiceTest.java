import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.StudentsService;

@SpringBootTest(classes={StudentsService.class, StudentRepository.class, CourseRepository.class, ListCoursesRepository.class})
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Test
    void findByIdFioTest(){
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        var result = repository.findById(1L).orElseThrow();
        Assertions.assertEquals(student.getFio(), result.getFio());
    }

    @Test
    void findByIdEmailTest(){
        Student student = new Student();
        student.setEmail("ivanov@test.com");
        var result = repository.findById(1L).orElseThrow();
        Assertions.assertEquals(student.getEmail(), result.getEmail());
    }
}
