# FizzBuzz

A project of Alice and François

A simple Java 21 Maven project implementing the classic FizzBuzz problem.

## Project Structure

```
fizzbuzz/
├── pom.xml                          # Maven configuration
├── README.md                        # This file
├── .gitignore                       # Git ignore file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── fizzbuzz/
│   │   │               └── FizzBuzz.java    # Main implementation class
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── fizzbuzz/
│       │               └── FizzBuzzTest.java  # JUnit 5 test class
│       └── resources/
└── target/                          # Build output (generated)
```

## Requirements

- Java 21
- Maven 3.8+
- JUnit 5 (included in Maven dependencies)

## Building and Running

### Compile the project
```bash
mvn clean compile
```

### Run tests
```bash
mvn test
```

### Generate test coverage report
```bash
mvn jacoco:report
```

### Clean and package
```bash
mvn clean package
```

## Implementation

The `FizzBuzz` class provides:

- `process(int number)`: Returns "Fizz", "Buzz", "FizzBuzz", or the number as string
- `generateSequence(int limit)`: Generates FizzBuzz sequence from 1 to limit

## Testing

The `FizzBuzzTest` class includes comprehensive tests using:
- Parameterized tests with `@ValueSource`
- Parameterized tests with `@CsvSource`
- Edge case testing
- Invalid input testing
