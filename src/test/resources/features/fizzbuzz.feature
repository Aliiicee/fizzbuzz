Feature: Enhanced FizzBuzz Number Processing
  As a user of the FizzBuzz application
  I want to process numbers according to enhanced FizzBuzz rules
  So that I can get the correct string representation for each number based on multiples and contained digits

  Scenario Outline: Regular Numbers (no 3 or 5 digits)
    Given I have the number <number>
    When I process the number
    Then the result should be "<result>"

    Examples:
      | number | result |
      | 1      | 1      |
      | 2      | 2      |
      | 4      | 4      |
      | 7      | 7      |
      | 8      | 8      |
      | 11     | 11     |
      | 14     | 14     |
      | 16     | 16     |
      | 17     | 17     |
      | 19     | 19     |
      | 22     | 22     |
      | 26     | 26     |
      | 28     | 28     |
      | 29     | 29     |
      | 41     | 41     |
      | 44     | 44     |
      | 46     | 46     |
      | 47     | 47     |
      | 49     | 49     |
      | 61     | 61     |
      | 62     | 62     |
      | 64     | 64     |
      | 67     | 67     |
      | 68     | 68     |
      | 71     | 71     |
      | 74     | 74     |
      | 76     | 76     |
      | 77     | 77     |
      | 79     | 79     |
      | 82     | 82     |
      | 86     | 86     |
      | 88     | 88     |
      | 89     | 89     |
      | 91     | 91     |
      | 92     | 92     |
      | 94     | 94     |
      | 97     | 97     |
      | 98     | 98     |

  Scenario Outline: Fizz Numbers (multiples of 3 or contain digit 3)
    Given I have the number <number>
    When I process the number
    Then the result should be "Fizz"

    Examples:
      | number |
      | 3      |
      | 6      |
      | 9      |
      | 12     |
      | 13     |
      | 18     |
      | 21     |
      | 23     |
      | 24     |
      | 27     |
      | 31     |
      | 33     |
      | 36     |
      | 39     |
      | 42     |
      | 43     |
      | 48     |
      | 63     |
      | 66     |
      | 69     |
      | 72     |
      | 78     |
      | 81     |
      | 84     |
      | 87     |
      | 93     |
      | 96     |
      | 99     |

  Scenario Outline: Buzz Numbers (multiples of 5 or contain digit 5)
    Given I have the number <number>
    When I process the number
    Then the result should be "Buzz"

    Examples:
      | number |
      | 5      |
      | 10     |
      | 20     |
      | 25     |
      | 40     |
      | 50     |
      | 52     |
      | 55     |
      | 59     |
      | 65     |
      | 70     |
      | 80     |
      | 85     |
      | 95     |
      | 100    |

  Scenario Outline: FizzBuzz Numbers (multiples of both 3 and 5 OR contain both digits 3 and 5)
    Given I have the number <number>
    When I process the number
    Then the result should be "FizzBuzz"

    Examples:
      | number |
      | 15     |
      | 30     |
      | 35     |
      | 45     |
      | 53     |
      | 60     |
      | 75     |
      | 90     |
      | 135    |
      | 153    |

  Scenario Outline: New Requirement Examples
    Given I have the number <number>
    When I process the number
    Then the result should be "<result>"

    Examples:
      | number | result    |
      | 3      | Fizz      |
      | 15     | FizzBuzz  |
      | 35     | FizzBuzz  |

  Scenario: Generate complete FizzBuzz sequence from 1 to 100
    Given I want to generate a FizzBuzz sequence from 1 to 100
    When I generate the sequence
    Then I should get 100 elements
    And the sequence should follow enhanced FizzBuzz rules for all numbers