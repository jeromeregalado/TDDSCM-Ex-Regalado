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
class EmployeeServiceTest {


    @Mock
    private EmployeeRespository employeeRespository;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();


    // Employee, Jhon Lyoyd, 23, 100000
    // Employee, Alejandro, 23, 150000
    // Employee, Wayne, 30, 20000
    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesThatAreEarningMoreThan is executed with input 90000 " +
            "THEN result should return Jhon ly  oyd and Alejandro")
    public void testEmployeesEarningMoreThanAmount() {
        //arrange
        Employee wayne = new Employee("Wayne", 20000d);
        Employee alejandro = new Employee("Alejandro", 150000d);
        Employee jhon_lyoyd = new Employee("Jhon Lyoyd", 100000d);
        List<Employee> employees = List.of(wayne
                , alejandro, jhon_lyoyd);

        Mockito.when(employeeRespository.getAllEmployees())
                .thenReturn(employees);
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesThatAreEarningMoreThan(90000d);

        //assert
        assertThat(filteredEmployees).contains(alejandro, jhon_lyoyd);
    }
}