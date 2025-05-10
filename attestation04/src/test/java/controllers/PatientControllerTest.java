package controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.controller.EmployeeController;
import ru.innopolis.controller.PatientController;
import ru.innopolis.entity.EmployeeEntity;
import ru.innopolis.entity.PatientEntity;
import ru.innopolis.service.EmployeeService;
import ru.innopolis.service.PatientService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {PatientController.class})
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PatientService patientService;

    @Test
    public void getPatient() throws Exception{
        Long id = 1L;
        var response = PatientEntity.builder()
                .id(1L)
                .fio("Петров Петр Петрович")
                .tel("+79876543210")
                .address("ул.Южная, д.2, кв.10")
                .build();

        Mockito.when(patientService.findById(id)).thenReturn(response);
        mockMvc.perform(get("api/v1/patient/1")).andExpect(status().isOk());
    }
}
