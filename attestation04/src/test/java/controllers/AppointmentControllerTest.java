package controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.controller.AppointmentsController;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.service.AppointmentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {AppointmentsController.class})
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AppointmentService appointmentService;

    @Test
    public void getAppointment() throws Exception{
        Long id = 1L;
        var response = AppointmentsEntity.builder()
                .id(1L)
                .idEmpl(1L)
                .idPat(1L)
                .time("10.05.2025")
                .description("Test")
                .build();

        Mockito.when(appointmentService.findById(id)).thenReturn(response);
        mockMvc.perform(get("api/v1/appointment/1")).andExpect(status().isOk());
    }
}
