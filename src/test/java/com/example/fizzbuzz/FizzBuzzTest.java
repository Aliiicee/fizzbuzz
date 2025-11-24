package com.example.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for FizzBuzz implementation.
 * Uses JUnit 5 for testing functionality.
 */
class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    /**
     * Set up test fixtures before each test.
     */
    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    /**
     * Test regular numbers that should return themselves as strings.
     * Updated for new requirements (numbers containing 3 or 5 are affected).
     */
    @Test
    void testRegularNumbers() {
        assertEquals("1", fizzBuzz.process(1));
        assertEquals("2", fizzBuzz.process(2));
        assertEquals("4", fizzBuzz.process(4));
        assertEquals("7", fizzBuzz.process(7));
        assertEquals("8", fizzBuzz.process(8));
        assertEquals("11", fizzBuzz.process(11));
        assertEquals("14", fizzBuzz.process(14));
        assertEquals("16", fizzBuzz.process(16));
    }

    /**
     * Test numbers divisible by 3 should return "Fizz".
     */
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18})
    void testFizzNumbers(int number) {
        assertEquals("Fizz", fizzBuzz.process(number));
    }

    /**
     * Test numbers divisible by 5 should return "Buzz".
     * Note: 35 should return "FizzBuzz" under new rules since it contains both 3 and 5.
     */
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 40, 50})
    void testBuzzNumbers(int number) {
        assertEquals("Buzz", fizzBuzz.process(number));
    }

    /**
     * Test numbers divisible by both 3 and 5 should return "FizzBuzz".
     */
    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75})
    void testFizzBuzzNumbers(int number) {
        assertEquals("FizzBuzz", fizzBuzz.process(number));
    }

    /**
     * test various scenarios with CSV source.
     */
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz"
    })
    void testFizzBuzzWithCsvSource(int input, String expected) {
        assertEquals(expected, fizzBuzz.process(input));
    }

    /**
     * Test sequence generation with new requirements.
     */
    @Test
    void testGenerateSequence() {
        String[] sequence = fizzBuzz.generateSequence(5);
        assertEquals(5, sequence.length);
        assertEquals("1", sequence[0]);      // 1 -> "1"
        assertEquals("2", sequence[1]);      // 2 -> "2"
        assertEquals("Fizz", sequence[2]);   // 3 -> "Fizz" (contains 3)
        assertEquals("4", sequence[3]);      // 4 -> "4"
        assertEquals("Buzz", sequence[4]);   // 5 -> "Buzz" (contains 5)
    }

    /**
     * Test edge cases for sequence generation.
     */
    @Test
    void testSequenceEdgeCases() {
        // Test with limit 0
        String[] emptySequence = fizzBuzz.generateSequence(0);
        assertEquals(0, emptySequence.length);
        
        // Test with negative limit
        String[] negativeSequence = fizzBuzz.generateSequence(-5);
        assertEquals(0, negativeSequence.length);
        
        // Test with limit 1
        String[] singleSequence = fizzBuzz.generateSequence(1);
        assertEquals(1, singleSequence.length);
        assertEquals("1", singleSequence[0]);
    }

    /**
     * Test numbers that contain digit 3 should return "Fizz".
     */
    @ParameterizedTest
    @ValueSource(ints = {3, 13, 23, 31, 32, 33, 34, 36, 37, 38, 39, 43, 73, 83, 93})
    void testNumbersContaining3(int number) {
        assertEquals("Fizz", fizzBuzz.process(number));
    }

    /**
     * Test numbers that contain digit 5 should return "Buzz".
     */
    @ParameterizedTest
    @ValueSource(ints = {5, 25, 52, 56, 58, 59, 65, 85, 95})
    void testNumbersContaining5(int number) {
        assertEquals("Buzz", fizzBuzz.process(number));
    }

    /**
     * Test numbers that contain both digits 3 and 5 should return "FizzBuzz".
     */
    @ParameterizedTest
    @ValueSource(ints = {35, 53, 135, 153, 315, 351, 513, 531})
    void testNumbersContaining3And5(int number) {
        assertEquals("FizzBuzz", fizzBuzz.process(number));
    }

    /**
     * Test the new requirements with specific examples from the prompt.
     */
    @Test
    void testNewRequirementExamples() {
        assertEquals("Fizz", fizzBuzz.process(3));
        assertEquals("FizzBuzz", fizzBuzz.process(15));
        assertEquals("FizzBuzz", fizzBuzz.process(35));
    }

    /**
     * Test edge cases for digit detection.
     */
    @Test
    void testDigitDetectionEdgeCases() {
        // Test with negative numbers containing digits
        assertEquals("-1", fizzBuzz.process(-1));
        assertEquals("-2", fizzBuzz.process(-2));
        assertEquals("-4", fizzBuzz.process(-4));
        assertEquals("-7", fizzBuzz.process(-7));
        assertEquals("-8", fizzBuzz.process(-8));

        // Test single digit numbers
        assertEquals("Fizz", fizzBuzz.process(3));
        assertEquals("Buzz", fizzBuzz.process(5));
        assertEquals("1", fizzBuzz.process(1));
        assertEquals("2", fizzBuzz.process(2));
        assertEquals("4", fizzBuzz.process(4));
    }

    /**
     * Test invalid inputs.
     */
    @Test
    void testInvalidInputs() {
        // Test with 0 (edge case)
        assertEquals("0", fizzBuzz.process(0));

        // Test with negative numbers that don't contain 3 or 5
        assertEquals("-1", fizzBuzz.process(-1));
        assertEquals("-2", fizzBuzz.process(-2));
        assertEquals("-4", fizzBuzz.process(-4));
        assertEquals("-7", fizzBuzz.process(-7));

        // Test with negative numbers containing 3 or 5 (should still be treated as negative)
        assertEquals("-3", fizzBuzz.process(-3));
        assertEquals("-5", fizzBuzz.process(-5));
        assertEquals("-15", fizzBuzz.process(-15));
    }
}