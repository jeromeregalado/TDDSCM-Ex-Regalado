package com.example.RegaladoTDDSCM;

public class EmployeeServiceTxtGen {

        public static String textInput(String name, int age, Double salary, String position)
        {
            String format = "%s, %d, %.2f, %s".formatted(name, age, salary, position);
            return format;
        }

}


