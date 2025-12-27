# Selenium TestNG Automation – LambdaTest

This project demonstrates parallel test execution using Selenium WebDriver and TestNG on the LambdaTest cloud platform.
The setup is configured to run inside Gitpod.

---

## Project Overview

* Parallel test execution using TestNG
* Cross-browser testing (Chrome and Firefox)
* Cloud execution using LambdaTest
* Thread-safe WebDriver implementation
* Gitpod-compatible setup

---

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* LambdaTest
* Gitpod

---

## Project Structure

```
.
├── src
│   └── test
│       └── java
│           └── com
│               └── lambdatest
│                   ├── BaseTest.java
│                   ├── TestScenario_1.java
│                   ├── TestScenario_2.java
│                   └── TestScenario_3.java
│
├── testng.xml
├── pom.xml
├── .gitpod.yml
└── README.md
```

---

## Gitpod Setup

Open the project using:

```
https://gitpod.io/#https://github.com/JegathaMurugan/LambdaSeleniumAutomation
```

---

## Set LambdaTest Credentials

Set the following environment variables inside Gitpod:

```
export LT_USERNAME="your_lambdatest_username"
export LT_ACCESS_KEY="your_lambdatest_access_key"
```

---

## Running the Tests

### Using Maven

```
mvn clean test
```

### Using TestNG XML

```
mvn test -DsuiteXmlFile=testng.xml
```

---

## Notes

* Test execution is controlled through `testng.xml`.
* Credentials must be provided using environment variables.
* Parallel execution depends on LambdaTest concurrency limits.
* Do not hardcode credentials in the codebase.

---

## Author

Jegatha Murugan

---

End of README
