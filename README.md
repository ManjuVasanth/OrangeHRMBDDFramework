# OrangeHRM BDD Framework

This repository contains a **BDD (Behavior Driven Development)** test automation framework for the **OrangeHRM** application. The framework uses **Cucumber** for defining user stories, **Selenium WebDriver** for interacting with the web application, and **TestNG** as the test runner. This setup is designed to create a structured and scalable approach to testing the OrangeHRM application.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [How to Run Tests](#how-to-run-tests)
- [Test Approach](#test-approach)
  - [POM (Page Object Model)](#pom-page-object-model)
  - [BDD (Behavior Driven Development)](#bdd-behavior-driven-development)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

This project focuses on the **OrangeHRM** (Orange Human Resource Management) system. The test automation suite is built using **Cucumber** for BDD, combined with **Selenium WebDriver** for browser automation and **TestNG** for executing tests. The framework is designed following **Page Object Model (POM)** to enhance code reusability, maintainability, and readability.

The framework automates key functionalities in the OrangeHRM system such as:
- Employee management
- Admin features
- Leave management
- Time tracking
- Recruitment

## Technologies Used

- **Java**: Programming language for the automation scripts.
- **Selenium WebDriver**: Browser automation tool to interact with the web application.
- **Cucumber**: BDD tool for writing human-readable test cases.
- **TestNG**: Test runner and assertion library.
- **Maven**: Dependency management and build tool.
- **Extent Reports**: For generating test reports.

## Project Structure

```
src
│
├── main
│   └── java
│       └── pageObjects       # POM structure for page classes
│       └── utilities         # Helper classes for common functions
│
├── test
│   └── java
│       └── stepDefinitions   # Cucumber step definitions
│       └── features          # Cucumber feature files
│       └── testRunners       # TestNG runners for executing tests
│
└── README.md                 # Project documentation
```

## Setup and Installation

### Prerequisites

Before you begin, ensure you have the following installed:
- **Java 8 or above**
- **Maven**
- **Chrome WebDriver** or **Firefox WebDriver** (based on the browser you want to use)
- **IDE** like Eclipse or IntelliJ IDEA

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ManjuVasanth/OrangeHRMBDDFramework.git
   ```

2. Navigate to the project directory:

   ```bash
   cd OrangeHRMBDDFramework
   ```

3. Install dependencies using Maven:

   ```bash
   mvn clean install
   ```

## How to Run Tests

### Running all tests

To run all the tests in the project, use the following Maven command:

```bash
mvn test
```

### Running specific scenarios

You can also run specific scenarios or features using **Cucumber tags**. For example:

```bash
mvn test -Dcucumber.options="--tags @smoke"
```

This will run all scenarios tagged as `@smoke`.

### Running tests with TestNG

TestNG XML files are used to define test execution. To run tests using TestNG, execute:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Test Approach

### POM (Page Object Model)

The project follows the **Page Object Model** (POM) design pattern, which encapsulates the page interactions in dedicated classes for each page of the application. This helps in maintaining a clean separation between the test logic and the UI interaction code.

- **LoginPage**: Contains methods related to login actions.
- **DashboardPage**: Handles interactions after login.
- **EmployeePage**: Manages employee-related actions (add, edit, delete employees).
- **AdminPage**: Admin functionalities of the OrangeHRM system.

### BDD (Behavior Driven Development)

**Cucumber** is used for BDD, where user stories are written in Gherkin syntax in `.feature` files. Each feature file contains scenarios representing test cases written in natural language that are easy to understand.

Example of a **Login feature** in Cucumber:

```gherkin
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given User is on the OrangeHRM login page
    When User enters valid username and password
    And clicks on Login button
    Then User should be redirected to the dashboard page
```

### TestNG Integration

The framework is integrated with **TestNG** to define and run test suites. TestNG allows parallel execution, grouping of test cases, and custom test configurations.

## Reporting

The project is integrated with **Extent Reports** to provide detailed and visually appealing test execution reports. After each test run, the test results will be generated in the `test-output` folder, including information on test case execution, pass/fail status, and screenshots of failed test steps.

## Contributing

Contributions are welcome! If you'd like to contribute to the project, follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a Pull Request.

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

Feel free to modify or update this `README.md` as per your project's evolving needs!


