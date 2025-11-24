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
     * Processes a number according to enhanced FizzBuzz rules.
     * Handles non-positive numbers as special cases since traditional FizzBuzz is for positive integers.
     *
     * @param number the input number to process
     * @return "Fizz" if divisible by 3 or contains digit 3, "Buzz" if divisible by 5 or contains digit 5,
     *         "FizzBuzz" if divisible by both 3 and 5 or contains both digits 3 and 5,
     *         or the number as string otherwise
     */
    public String process(int number) {
        // Handle non-positive numbers as special cases since traditional FizzBuzz starts from 1
        if (number <= 0) {
            return String.valueOf(number);
        }

        boolean isMultipleOf3 = number % 3 == 0;
        boolean isMultipleOf5 = number % 5 == 0;
        boolean contains3 = containsDigit(number, 3);
        boolean contains5 = containsDigit(number, 5);

        boolean shouldFizz = isMultipleOf3 || contains3;
        boolean shouldBuzz = isMultipleOf5 || contains5;

        if (shouldFizz && shouldBuzz) {
            return "FizzBuzz";
        } else if (shouldFizz) {
            return "Fizz";
        } else if (shouldBuzz) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    /**
     * Helper method to check if a number contains a specific digit.
     *
     * @param number the number to check
     * @param digit the digit to look for (0-9)
     * @return true if the number contains the digit, false otherwise
     */
    private boolean containsDigit(int number, int digit) {
        if (number < 0) {
            number = Math.abs(number);
        }

        String numberStr = String.valueOf(number);
        return numberStr.contains(String.valueOf(digit));
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