package com.example.RegaladoTDDSCM;

public class FizzBuzz {

    public String convert(int i) {

        boolean buzzCondition = i % 5 == 0;
        boolean fizzCondition = i % 3 == 0;
        boolean fizzBuzzCondition = buzzCondition && fizzCondition;

        if (fizzBuzzCondition) {
            return "FizzBuzz";
        }

        if (buzzCondition) {
            return "Buzz";
        }

        if (fizzCondition) {
            return "Fizz";
        }

        return String.valueOf(i);
    }
}
