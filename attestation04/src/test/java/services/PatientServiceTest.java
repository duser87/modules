package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.service.PatientService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(classes = PatientService.class)
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Test
    public void getEmployees(){
        Long id = 1L;
        var result = patientService.findById(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
        assertThat(id, equalTo(result.getId()));
    }
}
