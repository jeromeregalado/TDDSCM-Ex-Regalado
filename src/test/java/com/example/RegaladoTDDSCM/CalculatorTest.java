package com.example.RegaladoTDDSCM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {


    @Test
    public void givenNum1Five_and_Num2Three_ResultShouldBe_8() {
        //Arrange => SETUP the things that the function under test needs
        int num1 = 5;
        int num2 = 3;
        Calculator calculator = new Calculator();

        //ACT => Trogger the function under test
        int result = calculator.add(num1, num2);


        //ASSERT => Validate the result processed by the ACT
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("When an input of negative value is provided, Illegal Argument exception is thrown")
    public void exceptionCaseForNegativeNumber() {
        //arrange
        int num1 = -2;
        int num2 = -3;
        Calculator calculator = new Calculator();

        //ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            //ACT => Trogger the function under test
            int result = calculator.add(num1, num2);
        });
    }

    @Test
    public void subtract_givenNum1AndNum2_resultShouldBe_Num1MinusNum2() {
        //ARRANGE
        int num1 = 1000000;
        int num2 = 500000;
        Calculator calculator = new Calculator();

        //ACT
        int result = calculator.subtract(num1, num2);

        //ASSERT
        int expected = 500000;
        assertEquals(expected, result);
    }

    @Test
    public void multiply_givenNum1And2_resultShouldBe_Num1TimesNum2() {
        //ARRANGE
        int num1 = 5;
        int num2 = 10;
        Calculator calculator = new Calculator();

        //ACT
        int result = calculator.multiply(num1, num2);

        //ASSERT
        int expected = 50;
        assertEquals(expected, result);
    }


}
