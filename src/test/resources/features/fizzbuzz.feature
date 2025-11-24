Feature: FizzBuzz Number Processing
  As a user of the FizzBuzz application
  I want to process numbers according to FizzBuzz rules
  So that I can get the correct string representation for each number

  Scenario Outline: Regular Numbers
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
      | 13     | 13     |
      | 14     | 14     |
      | 16     | 16     |
      | 17     | 17     |
      | 19     | 19     |
      | 22     | 22     |
      | 23     | 23     |
      | 26     | 26     |
      | 28     | 28     |
      | 29     | 29     |
      | 31     | 31     |
      | 32     | 32     |
      | 34     | 34     |
      | 37     | 37     |
      | 38     | 38     |
      | 41     | 41     |
      | 43     | 43     |
      | 44     | 44     |
      | 46     | 46     |
      | 47     | 47     |
      | 49     | 49     |
      | 52     | 52     |
      | 53     | 53     |
      | 56     | 56     |
      | 58     | 58     |
      | 59     | 59     |
      | 61     | 61     |
      | 62     | 62     |
      | 64     | 64     |
      | 67     | 67     |
      | 68     | 68     |
      | 71     | 71     |
      | 73     | 73     |
      | 74     | 74     |
      | 76     | 76     |
      | 77     | 77     |
      | 79     | 79     |
      | 82     | 82     |
      | 83     | 83     |
      | 86     | 86     |
      | 88     | 88     |
      | 89     | 89     |
      | 91     | 91     |
      | 92     | 92     |
      | 94     | 94     |
      | 97     | 97     |
      | 98     | 98     |

  Scenario Outline: Fizz Numbers (multiples of 3)
    Given I have the number <number>
    When I process the number
    Then the result should be "Fizz"

    Examples:
      | number |
      | 3      |
      | 6      |
      | 9      |
      | 12     |
      | 18     |
      | 21     |
      | 24     |
      | 27     |
      | 33     |
      | 36     |
      | 39     |
      | 42     |
      | 48     |
      | 51     |
      | 54     |
      | 57     |
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

  Scenario Outline: Buzz Numbers (multiples of 5)
    Given I have the number <number>
    When I process the number
    Then the result should be "Buzz"

    Examples:
      | number |
      | 5      |
      | 10     |
      | 20     |
      | 25     |
      | 35     |
      | 40     |
      | 50     |
      | 55     |
      | 65     |
      | 70     |
      | 80     |
      | 85     |
      | 95     |
      | 100    |

  Scenario Outline: FizzBuzz Numbers (multiples of both 3 and 5)
    Given I have the number <number>
    When I process the number
    Then the result should be "FizzBuzz"

    Examples:
      | number |
      | 15     |
      | 30     |
      | 45     |
      | 60     |
      | 75     |
      | 90     |

  Scenario: Generate complete FizzBuzz sequence from 1 to 100
    Given I want to generate a FizzBuzz sequence from 1 to 100
    When I generate the sequence
    Then I should get 100 elements
    And the sequence should follow FizzBuzz rules for all numbers