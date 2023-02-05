import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;
import com.revature.service.EmployeeService;

/*
 * Mocking is when you replace a real Java class with something that isn't and usually returns a hard-coded value
 */

 // Unit Test our EmployeeService class in our Service layer
public class EmployeeServiceTest {
    
    @Test
    public void Get_All_Employees_Should_Give_All_Employees() {

        // Arrange 
        EmployeeService empServ = new EmployeeService();
        EmployeeRepository mockEmpRepo = Mockito.mock(EmployeeRepository.class);

        // Tell Mockito to guarantee that if a specific method was called in our mock object, go ahead return hardcoded value
        List<Employee> expectedListOfEmps = new ArrayList<Employee>();
        expectedListOfEmps.add(new Employee());
        expectedListOfEmps.add(new Employee());
        expectedListOfEmps.add(new Employee());

        Mockito.when(mockEmpRepo.getAllEmployees()).thenReturn(expectedListOfEmps);

        // Act
        String jsonListEmps = empServ.getAllEmps();

        // Assert 
        assertNotEquals("null", jsonListEmps);
    }
}
