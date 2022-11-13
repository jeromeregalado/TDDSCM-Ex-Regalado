package com.example.RegaladoTDDSCM;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeRepositoryFromCSV implements EmployeeRespository {
    private static final String PATH_CSV = "C:\\Users\\Jerome.Regalado\\Desktop\\FizzBuzzTDD\\src\\main\\resources\\datastore.csv";


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeesFromCSV = populateList();
        return employeesFromCSV;
    }

    public static List<Employee> populateList()
    {
        // TODO - List
        List<Employee> employeeList = new ArrayList<>();
        Path path = Paths.get(PATH_CSV);
        try
            {
            // TODO - Predicate not, isBlank, readString, lines
            List<String> output = Files.readString(path)
                    .lines()
                    .filter(Predicate.not(String::isBlank)).toList();
            for (String out : output) {
                String[] spl = out.split(",");
                employeeList.add(new Employee(spl[0], Integer.parseInt(spl[1]), Double.parseDouble(spl[2]), spl[3]));
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
        return employeeList;
    }
}
