package com.example.RegaladoTDDSCM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    Employee wayne = new Employee("Wayne", 30, 20000d, "softwareengineer");
    Employee Test2 = new Employee("Test2", 23, 200000d, "softwareengineer");
    Employee Test3 = new Employee("Test3", 25, 2000000d, "softwareengineer");

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        List<Employee> employees = List.of(wayne, Test2, Test3);

        Mockito.when(employeeService.getAllEmployees())
                .thenReturn(employees);
    }

    @Test
    @DisplayName("Given a request, " +
            "EmployeeController should " +
            "execute Service")
    public void getAllEmployeesTest() {
        //arrange
        setup();
        //act
        List<Employee> employeeList = employeeController.getAllEmployees();

        //assert
        assertThat(employeeList).contains(wayne, Test2, Test3);
    }
}
