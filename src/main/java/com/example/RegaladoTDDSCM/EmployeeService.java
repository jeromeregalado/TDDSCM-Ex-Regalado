package com.example.RegaladoTDDSCM;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeService {

    @Autowired
    private EmployeeRespository employeeRespository;

    public List<Employee> getAllEmployees() {
        return employeeRespository.getAllEmployees().stream().toList();
    }

    public List<Employee> getAllEmployeesThatAreEarningMoreThan(Double amount) {
        return employeeRespository.getAllEmployees().stream().filter(employee -> employee.getSalary() > amount)
                .collect(Collectors.toList());
    }


    public List<Employee> getAllEmployeesExceedingAge(int age){
        return employeeRespository.getAllEmployees().stream().filter(employee -> employee.getAge() > age)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeesWithMatchingPosition(String position){
        return employeeRespository.getAllEmployees().stream().filter(employee -> employee.getPosition().equals(position))
                .toList();
    }

    public List<Employee> getEmployeeWithHighestSalary(){
        return employeeRespository.getAllEmployees().stream().max(Comparator.comparing(Employee::getSalary)).stream().collect(Collectors.toList());
    }

}
