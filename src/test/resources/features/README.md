# FizzBuzz Gherkin Tests

This directory contains the Gherkin feature files for testing the FizzBuzz functionality using Behavior-Driven Development (BDD) approach with Cucumber.

## Files

- `fizzbuzz.feature`: Contains all the test scenarios for numbers 1-100, organized into:
  - Regular Numbers: Numbers not divisible by 3 or 5
  - Fizz Numbers: Multiples of 3
  - Buzz Numbers: Multiples of 5
  - FizzBuzz Numbers: Multiples of both 3 and 5
  - Complete sequence generation test

## Running the Tests

### Using Maven
```bash
# Run all tests including Cucumber tests
mvn test

# Run only Cucumber tests
mvn test -Dcucumber.options="--tags '@FizzBuzz'"
```

### From IDE
- Run the `RunCucumberTest.java` class as a JUnit test

## Test Coverage

The feature file tests all numbers from 1 to 100:
- 53 regular numbers (not divisible by 3 or 5)
- 27 Fizz numbers (multiples of 3)
- 14 Buzz numbers (multiples of 5)
- 6 FizzBuzz numbers (multiples of both 3 and 5)

## Step Definitions

The step definitions are located in:
`src/test/java/com/example/fizzbuzz/stepdefinitions/FizzBuzzStepDefinitions.java`

These step definitions connect the Gherkin scenarios to the actual FizzBuzz implementation.