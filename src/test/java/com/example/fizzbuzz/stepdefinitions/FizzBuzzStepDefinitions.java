package com.example.fizzbuzz.stepdefinitions;

import com.example.fizzbuzz.FizzBuzz;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Step definitions for FizzBuzz feature scenarios.
 * This class connects Gherkin scenarios to the FizzBuzz implementation.
 */
public class FizzBuzzStepDefinitions {

    private FizzBuzz fizzBuzz;
    private int inputNumber;
    private String result;
    private String[] sequence;
    private int sequenceLimit = -1;

    @Given("I have the number {int}")
    public void iHaveTheNumber(int number) {
        fizzBuzz = new FizzBuzz();
        inputNumber = number;
    }

    @When("I process the number")
    public void iProcessTheNumber() {
        result = fizzBuzz.process(inputNumber);
    }

    @Then("the result should be {string}")
    public void theResultShouldBe(String expectedResult) {
        assertEquals(expectedResult, result);
    }

    
    @When("I generate the sequence")
    public void iGenerateTheSequence() {
        // Use sequenceLimit if it's been set (including 0), otherwise default to 100
        // Use -1 as the "not set" sentinel value instead of 0
        int limit = (sequenceLimit != -1) ? sequenceLimit : 100;
        sequence = fizzBuzz.generateSequence(limit);
        sequenceLimit = -1; // Reset to sentinel value
    }

    
    @And("the sequence should follow FizzBuzz rules for all numbers")
    public void theSequenceShouldFollowFizzBuzzRulesForAllNumbers() {
        for (int i = 1; i <= sequence.length; i++) {
            String expected = getExpectedFizzBuzzValue(i);
            assertEquals(expected, sequence[i - 1],
                "Mismatch at position " + i + " (number " + i + ")");
        }
    }

    @And("the sequence should follow enhanced FizzBuzz rules for all numbers")
    public void the_sequence_should_follow_enhanced_fizz_buzz_rules_for_all_numbers() {
        for (int i = 1; i <= sequence.length; i++) {
            String expected = getExpectedEnhancedFizzBuzzValue(i);
            assertEquals(expected, sequence[i - 1],
                "Mismatch at position " + i + " (number " + i + ")");
        }
    }

    @Given("I want to generate a FizzBuzz sequence from 1 to {int}")
    public void iWantToGenerateAFizzBuzzSequenceFrom1To(int limit) {
        fizzBuzz = new FizzBuzz();
        this.sequenceLimit = limit;
    }

    @Then("I should get {int} elements")
    public void iShouldGetElements(int expectedCount) {
        assertEquals(expectedCount, sequence.length);
    }

    /**
     * Helper method to determine the expected FizzBuzz value for a given number.
     * This follows the classic FizzBuzz rules:
     * - Non-positive numbers return themselves as strings (edge cases)
     * - Multiples of both 3 and 5 return "FizzBuzz"
     * - Multiples of 3 return "Fizz"
     * - Multiples of 5 return "Buzz"
     * - All other numbers return themselves as strings
     */
    private String getExpectedFizzBuzzValue(int number) {
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
     * Helper method to determine the expected enhanced FizzBuzz value for a given number.
     * This follows the enhanced FizzBuzz rules:
     * - Non-positive numbers return themselves as strings (edge cases)
     * - Return "FizzBuzz" if number is multiple of both 3 and 5 OR contains both digits 3 and 5
     * - Return "Fizz" if number is multiple of 3 OR contains digit 3
     * - Return "Buzz" if number is multiple of 5 OR contains digit 5
     * - All other numbers return themselves as strings
     */
    private String getExpectedEnhancedFizzBuzzValue(int number) {
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
     */
    private boolean containsDigit(int number, int digit) {
        if (number < 0) {
            number = Math.abs(number);
        }
        String numberStr = String.valueOf(number);
        return numberStr.contains(String.valueOf(digit));
    }
}