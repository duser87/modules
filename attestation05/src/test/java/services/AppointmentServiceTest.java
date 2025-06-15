package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.services.impl.AppointmentServiceImpl;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest(classes = AppointmentServiceImpl.class)
public class AppointmentServiceTest {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @Test
    public void getAppointment(){
        Long id = 1L;
        var result = appointmentService.findById(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
        assertThat(id, equalTo(result.getId()));
    }
}
