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

    @Given("I want to generate a FizzBuzz sequence from 1 to 100")
    public void iWantToGenerateAFizzBuzzSequenceFrom1To100() {
        fizzBuzz = new FizzBuzz();
    }

    @When("I generate the sequence")
    public void iGenerateTheSequence() {
        sequence = fizzBuzz.generateSequence(100);
    }

    @Then("I should get 100 elements")
    public void iShouldGet100Elements() {
        assertEquals(100, sequence.length);
    }

    @And("the sequence should follow FizzBuzz rules for all numbers")
    public void theSequenceShouldFollowFizzBuzzRulesForAllNumbers() {
        for (int i = 1; i <= 100; i++) {
            String expected = getExpectedFizzBuzzValue(i);
            assertEquals(expected, sequence[i - 1], 
                "Mismatch at position " + i + " (number " + i + ")");
        }
    }

    /**
     * Helper method to determine the expected FizzBuzz value for a given number.
     * This follows the FizzBuzz rules:
     * - Multiples of both 3 and 5 return "FizzBuzz"
     * - Multiples of 3 return "Fizz"
     * - Multiples of 5 return "Buzz"
     * - All other numbers return themselves as strings
     */
    private String getExpectedFizzBuzzValue(int number) {
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
}