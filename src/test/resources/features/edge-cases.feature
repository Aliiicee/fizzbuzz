Feature: Enhanced FizzBuzz Edge Cases
  As a user of the enhanced FizzBuzz application
  I want to handle edge cases like zero and negative numbers correctly
  So that the application behaves predictably for all integer inputs
  Note: Negative numbers and zero should return as strings, not follow FizzBuzz rules

  Scenario: Process zero
    Given I have the number 0
    When I process the number
    Then the result should be "0"

  Scenario Outline: Process negative numbers
    Given I have the number <number>
    When I process the number
    Then the result should be "<result>"

    Examples:
      | number | result |
      | -1     | -1     |
      | -2     | -2     |
      | -3     | -3     |
      | -4     | -4     |
      | -5     | -5     |
      | -15    | -15    |
      | -30    | -30    |

  Scenario: Generate empty sequence for zero limit
    Given I want to generate a FizzBuzz sequence from 1 to 0
    When I generate the sequence
    Then I should get 0 elements

  Scenario: Generate empty sequence for negative limit
    Given I want to generate a FizzBuzz sequence from 1 to -5
    When I generate the sequence
    Then I should get 0 elements