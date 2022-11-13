package com.example.RegaladoTDDSCM;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    public List<Employee> getEmployeesExceedingSalary(Double salary) {
        return null;
    }public List<Employee> getAllEmployeesThatAreEarningMoreThan(Double amount) {
        return employeeService.getAllEmployeesThatAreEarningMoreThan(amount);
    }


    public List<Employee> getAllEmployeesExceedingAge(int age){
        return employeeService.getAllEmployeesExceedingAge(age);
    }

    public List<Employee> getAllEmployeesWithMatchingPosition(String position) {
        return employeeService.getAllEmployeesWithMatchingPosition(position);
    }

    public List<Employee> getEmployeeWithHighestSalary() {
        return employeeService.getEmployeeWithHighestSalary();
    }


}
