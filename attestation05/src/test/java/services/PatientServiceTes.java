package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.services.impl.PatientServiceImpl;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest(classes = PatientServiceImpl.class)
public class PatientServiceTes {

    @Autowired
    private PatientServiceImpl patientService;

    @Test
    public void getEmployees(){
        Long id = 1L;
        var result = patientService.findById(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
        assertThat(id, equalTo(result.getId()));
    }

}
