package com.example.RegaladoTDDSCM;

public class Calculator {


    public int add(int num1, int num2) {

        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("Negative is not ALLOWED");
        }

        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }


    public int multiply(int num1, int num2) {
        return num1 * num2;
    }


}
