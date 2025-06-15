package controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.controllers.PatientController;
import ru.innopolis.models.DTO.response.PatientResponseDTO;
import ru.innopolis.services.PatientServiceInterface;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {PatientController.class})
public class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PatientServiceInterface patientService;

    @Test
    public void getPatient() throws Exception{
        Long id = 1L;
        var response = PatientResponseDTO.builder()
                .id(1L)
                .fio("Иванов Иван Иванович")
                .tel("+79876543210")
                .address("ул.Мира, д.1")
                .build();

        Mockito.when(patientService.findById(id)).thenReturn(response);
        mockMvc.perform(get("api/v1/patient/1")).andExpect(status().isOk());
    }
}
