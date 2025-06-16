package controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.controllers.EmployeeController;
import ru.innopolis.models.DTO.response.EmployeeResponseDTO;
import ru.innopolis.services.EmployeeServiceInterface;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {EmployeeController.class})
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeServiceInterface employeeService;

    @Test
    public void getEmployee() throws Exception{
        Long id = 1L;
        var response = EmployeeResponseDTO.builder()
                .id(1L)
                .fio("Иванов Иван Иванович")
                .tel("+79001234567")
                .build();

        Mockito.when(employeeService.findById(id)).thenReturn(response);
        mockMvc.perform(get("api/v1/employee/1")).andExpect(status().isOk());
    }
}
