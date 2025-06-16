package controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.controllers.AppointmentController;
import ru.innopolis.models.DTO.response.AppointmentResponseDTO;
import ru.innopolis.models.Entity.AppointmentEntity;
import ru.innopolis.services.AppointmentServiceInterface;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {AppointmentController.class})
public class AppointmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AppointmentServiceInterface appointmentService;

    @Test
    public void getAppointment() throws Exception{
        Long id = 1L;
        var response = AppointmentResponseDTO.builder()
                .id(1L)
                .idEmpl(1L)
                .idPat(5L)
                .time("10.05.2025")
                .description("Test")
                .build();

        Mockito.when(appointmentService.findById(id)).thenReturn(response);
        mockMvc.perform(get("api/v1/appointment/1")).andExpect(status().isOk());
    }
}
