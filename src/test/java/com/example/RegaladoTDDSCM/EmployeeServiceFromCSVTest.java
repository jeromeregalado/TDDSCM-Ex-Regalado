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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceFromCSVTest
{
    @Mock
    EmployeeRepositoryFromCSV employeeRespository;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();

    Employee wayne = new Employee("Wayne", 30, 20000d, "softwareengineer");
    Employee Test2 = new Employee("Test2", 23, 200000d, "softwareengineer");
    Employee Test3 = new Employee("Test3", 25, 2000000d, "softwareengineer");

    @BeforeEach
    public void setup()
    {

        List<Employee> employeesFromCSV = List.of(wayne, Test2, Test3);

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employeesFromCSV);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesThatAreEarningMoreThan is executed with input 90000 " +
            "THEN result should return Jhon Lyoyd and Alejandro")

    public void testEmployeesEarningMoreThanAmount() {
        //arrange
        setup();

        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesThatAreEarningMoreThan(90000d);

        //assert
        assertThat(filteredEmployees).contains(Test3, Test3);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesAge greater 24 " +
            "THEN result should return Wayne")
    public void testEmployeesAge() {
        //arrange
        setup();
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesExceedingAge(24);

        //assert
        assertThat(filteredEmployees).contains(wayne, Test3);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesWithMatchingPosition Instructor " +
            "THEN result should return Wayne")
    public void testEmployeePosition() {
        //arrange
        setup();
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesWithMatchingPosition("softwareengineer");

        //assert
        assertThat(filteredEmployees).contains(wayne, Test2,Test3);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesHighestSalary " +
            "THEN result should return Alejandro")
    public void testEmployeeHighestSalary() {
        //arrange
        setup();
        //act
        List<Employee> filteredEmployees = employeeService.getEmployeeWithHighestSalary();

        //assert
        assertThat(filteredEmployees).contains(Test3);
    }
/*
name = "Jojo"
age = 27
salary = 1000000000d
position = "softeng"

%d, %d, %d, %d .formatted(name,age,salary,position)
writepath
 */


}
