package com.example.fizzbuzz;

/**
 * FizzBuzz implementation class.
 * This class provides the classic FizzBuzz functionality.
 */
public class FizzBuzz {

    /**
     * Default constructor.
     */
    public FizzBuzz() {
    }

    /**
     * Processes a number according to FizzBuzz rules.
     * Handles non-positive numbers as special cases since traditional FizzBuzz is for positive integers.
     *
     * @param number the input number to process
     * @return "Fizz" if divisible by 3, "Buzz" if divisible by 5,
     *         "FizzBuzz" if divisible by both 3 and 5, or the number as string otherwise
     */
    public String process(int number) {
        // Handle non-positive numbers as special cases since traditional FizzBuzz starts from 1
        if (number <= 0) {
            return String.valueOf(number);
        }

        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    /**
     * Generates FizzBuzz sequence from 1 to the given limit.
     *
     * @param limit the upper bound of the sequence (inclusive)
     * @return array of strings representing the FizzBuzz sequence
     */
    public String[] generateSequence(int limit) {
        if (limit < 1) {
            return new String[0];
        }
        
        String[] sequence = new String[limit];
        for (int i = 1; i <= limit; i++) {
            sequence[i - 1] = process(i);
        }
        return sequence;
    }
}