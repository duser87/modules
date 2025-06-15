package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.innopolis.services.impl.EmployeeServiceImpl;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest(classes = EmployeeServiceImpl.class)
public class EmployeeServiceTest {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void getEmployees(){
        Long id = 1L;
        var result = employeeService.findById(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
        assertThat(id, equalTo(result.getId()));
    }
}
