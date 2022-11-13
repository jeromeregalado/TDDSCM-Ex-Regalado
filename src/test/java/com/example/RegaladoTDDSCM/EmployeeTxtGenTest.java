package com.example.RegaladoTDDSCM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeTxtGenTest {



    @Mock
    private EmployeeRespository employeeRespository;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();

    @Test
    @DisplayName("Given VARIABLES from input with setup above, " + "WHEN textGen")
    public void textGenTest()
    {
       String name = "Jerome";
        int age = 26;
        double salary = 10000d;
       String position = "softwareengineer1";
        Employee jerome = new Employee(name, age, salary, position);
        List<Employee> employees = List.of(jerome);

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employees);

        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesThatAreEarningMoreThan(9000d);

        //assert
        assertThat(filteredEmployees).contains(jerome);


    }

}
