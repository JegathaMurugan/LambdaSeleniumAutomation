# Selenium TestNG Automation – LambdaTest (Gitpod Enabled)

This project demonstrates parallel test execution using Selenium WebDriver, TestNG, and LambdaTest Cloud, configured to run seamlessly using Gitpod.

The repository includes a `.gitpod.yml` file to enable one‑click setup and execution in the Gitpod development environment.

---

## Project Overview

This automation framework supports:

* Parallel test execution using TestNG  
* Cross-browser testing (Chrome and Firefox)  
* Cloud-based execution on LambdaTest  
* Thread-safe WebDriver implementation  
* One‑click execution using Gitpod  

---

## Technologies Used

* Java  
* Selenium WebDriver  
* TestNG  
* Maven  
* LambdaTest  
* Gitpod  
* GitHub Codespaces  

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

## Gitpod Configuration

The project includes a `.gitpod.yml` file to automatically set up the environment.

### `.gitpod.yml` Configuration

```yaml
image: maven:3.9.0-eclipse-temurin-17

tasks:
  - init: mvn clean install
    command: mvn test -DsuiteXmlFile=testng.xml

vscode:
  extensions:
    - vscjava.vscode-java-pack
```

Note: In some Gitpod accounts, the VS Code web editor may not open automatically. If that happens, you can still use the terminal in Gitpod to run tests, or use GitHub Codespaces or a local environment instead.

---

## How to Run

### Option 1: Gitpod

1. Open the following URL in your browser:

```
https://gitpod.io/#https://github.com/JegathaMurugan/LambdaSeleniumAutomation
```

2. In the Gitpod terminal, set the following environment variables:

```
export LT_USERNAME="your_lambdatest_username"
export LT_ACCESS_KEY="your_lambdatest_access_key"
```

3. Run the tests:

```
mvn clean test
```

or

```
mvn test -DsuiteXmlFile=testng.xml
```

---

### Option 2: GitHub Codespaces (Recommended)

1. Open the repository on GitHub.  
2. Click **Code → Codespaces → Create codespace**.  
3. In the integrated terminal, set LambdaTest credentials:

```
export LT_USERNAME="your_lambdatest_username"
export LT_ACCESS_KEY="your_lambdatest_access_key"
```

4. Run:

```
mvn clean test
```

---

### Option 3: Local Execution (VS Code / Terminal / IDE)

1. Clone the repository:

```
git clone https://github.com/JegathaMurugan/LambdaSeleniumAutomation.git
cd LambdaSeleniumAutomation
```

2. Ensure you have:
   - Java 17 or newer  
   - Maven  

3. Set the environment variables:

```
export LT_USERNAME="your_lambdatest_username"
export LT_ACCESS_KEY="your_lambdatest_access_key"
```

4. Run:

```
mvn clean test
```

---

## Notes

* LambdaTest credentials must be provided using environment variables only.  
* Do not hardcode credentials in source code.  
* Parallel execution is controlled by the `testng.xml` file.  
* Test IDs generated during test execution can be found on the LambdaTest dashboard.  
* This setup works with Gitpod terminal, GitHub Codespaces, and local environments.

---

## Submission Checklist

* GitHub repository with this README  
* `.gitpod.yml` file present  
* Tests configured for parallel execution  
* LambdaTest credentials usage documented  
* Test IDs captured from the LambdaTest dashboard

---

## Example: Setting Credentials and Running Tests

```
export LT_USERNAME=mjegatha94
export LT_ACCESS_KEY=YOUR_NEW_ACCESS_KEY
mvn clean test
```

Replace `YOUR_NEW_ACCESS_KEY` with your actual LambdaTest access key.

End of README
