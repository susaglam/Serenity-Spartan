# Serenity Spartan Review

[![Java](https://img.shields.io/badge/Java-11-blue)](https://www.java.com/en/)
[![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-3.9.8-orange)](https://serenity-bdd.github.io/theserenitybook/latest/index.html)
[![JSON Schema Validator](https://img.shields.io/badge/JSON%20Schema%20Validator-2.2.6-brightgreen)](https://github.com/fge/json-schema-validator)
[![REST Assured](https://img.shields.io/badge/REST%20Assured-3.2.5-yellow)](https://rest-assured.io/)
[![JUnit 5](https://img.shields.io/badge/JUnit%205-5.7.1-red)](https://junit.org/junit5/)
[![Serenity JUnit 5](https://img.shields.io/badge/Serenity%20JUnit%205-1.6.0-blueviolet)](https://github.com/serenity-bdd/serenity-junit5)
[![Maven Surefire](https://img.shields.io/badge/Maven%20Surefire-3.1.2-lightgrey)](https://maven.apache.org/surefire/maven-surefire-plugin/)

This project is a demonstration of automated API testing using Serenity BDD and REST Assured. It includes test scenarios for the Spartan API, which is used to manage Spartan warriors.

## Technologies Used

- Java 11
- Serenity BDD (version 3.9.8)
- JSON Schema Validator (version 2.2.6)
- REST Assured (version 3.2.5)
- JUnit 5 (version 5.7.1)
- Serenity JUnit 5 (version 1.6.0)
- Maven Surefire (version 3.1.2)

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven

### Installation

1. Clone the repository: `git clone https://github.com/susaglam/Serenity-Spartan.git`
2. Navigate to the project directory: `cd Serenity-Spartan`

### Running the Tests

To run the API tests, execute the following Maven command in the project root directory:

```bash
mvn clean verify
```

The tests will be executed, and the test report will be generated under the `target/site/serenity` directory.

### Test Reports

After running the tests, you can find the test reports in the `target/site/serenity` directory. Open the `index.html` file in your web browser to view the test results and detailed test reports.

### API Documentation

The Spartan API documentation can be found at `http://xxxx:8000/api-docs` for reference.

## Contributing

Contributions are welcome! If you find any issues or want to add new features, please feel free to create a pull request or open an issue.

## Author

Sukru Saglam (core code cloned From CYDEO)
