# Selenium TestNG Automation – LambdaTest

This project demonstrates parallel test execution using Selenium WebDriver, TestNG, and LambdaTest Cloud.

---

**Project Overview**

This automation framework supports:

- Parallel test execution using TestNG  
- Cross-browser testing (Chrome and Firefox)  
- Cloud-based execution on LambdaTest  
- Thread-safe WebDriver implementation  

---

**Technologies Used**

Java | Selenium WebDriver | TestNG | Maven | LambdaTest | GitHub Codespaces

---

**Project Structure**

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

**How to Run**

***Option 1: GitHub Codespaces (Recommended)***

1. Open this repository on GitHub.  
2. Click **Code → Codespaces → Create codespace**.  
3. In the terminal, set LambdaTest credentials:

```
export LT_USERNAME="your_username"
export LT_ACCESS_KEY="your_access_key"
```

4. Run tests:

```
mvn clean test
```

---

***Option 2: Local Execution (VS Code / Terminal / IDE)***

1. Clone the repository:

```
git clone https://github.com/JegathaMurugan/LambdaSeleniumAutomation.git
cd LambdaSeleniumAutomation
```

2. Ensure Java 17+ and Maven are installed.  
3. Set credentials:

```
export LT_USERNAME="your_username"
export LT_ACCESS_KEY="your_access_key"
```

4. Run:

```
mvn clean test
```

---

**Notes**

- LambdaTest credentials must be provided using environment variables.  
- Do not hardcode credentials.  
- Parallel execution is controlled by `testng.xml`.  
- Test IDs from LambdaTest are available on the dashboard.  
- Some Gitpod accounts may not open the editor; use terminal or Codespaces/local instead.

---

**Submission Checklist**

- GitHub repository with this README  
- `.gitpod.yml` file present  
- Tests configured for parallel execution  
- LambdaTest credentials documented  
- Test IDs captured from the LambdaTest dashboard

---

**Example: Running Tests**

```
export LT_USERNAME=mjegatha94
export LT_ACCESS_KEY=YOUR_NEW_ACCESS_KEY
mvn clean test
```

Replace `YOUR_NEW_ACCESS_KEY` with your actual LambdaTest key.

End of README
