package com.example.RegaladoTDDSCM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {


    @Test
    @DisplayName("Given an input divisible by 3, return Fizz")
    public void givenAnInputOf3ReturnFizz() {
        //arrange
        int input = 3;

        //act
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actualResult = fizzBuzz.convert(input);

        //assert
        String expected = "Fizz";
        assertEquals(expected, actualResult);

    }

    @Test
    @DisplayName("Given an input divisible by 5, return Buzz")
    public void givenAnInputDivisibleBy5ReturnBuzz() {
        //arrange
        int input = 10;

        //act
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actualResult = fizzBuzz.convert(input);

        //assert
        String expected = "Buzz";
        assertEquals(expected, actualResult);

    }

    @Test
    @DisplayName("Given an input divisible by 5 and 3, return FizzBuzz")
    public void givenAnInputDivisibleBy3and5ReturnFizzBuzz() {
        //arrange
        int input = 15;

        //act
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actualResult = fizzBuzz.convert(input);

        //assert
        String expected = "FizzBuzz";
        assertEquals(expected, actualResult);

    }

    @Test
    @DisplayName("Given an input Not divisible by 3 or 5, return String num")
    public void defaultReturn() {
        //arrange
        int input = 4;

        //act
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actualResult = fizzBuzz.convert(input);

        //assert
        String expected = "4";
        assertEquals(expected, actualResult);

    }
}
