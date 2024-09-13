**UI & API Automation Project**
Overview
This repository contains a comprehensive automation framework developed using Java with Selenium for UI testing, and Rest Assured for API testing. The project is structured to provide efficient, reliable, and maintainable test automation for both UI and API endpoints. Performance testing is also included using JMeter. The continuous integration and delivery pipeline is managed with GitHub Actions, ensuring seamless deployments and reporting.

**Features**
*UI Automation*
Framework: Built with Java and Selenium WebDriver.
Design Patterns: Utilizes the Singleton Design Pattern for test management and the Page Object Model (POM) for a structured and maintainable test architecture.
Verification: Implemented using TestNG for reliable test assertions and verifications.
Listeners: Custom listeners capture screenshots on test failure and save them for further analysis.
Reporting: Test results are generated in HTML format for clear and detailed reporting.
CI/CD Integration: GitHub Actions is configured to run pipelines on every merge to the main branch. Test reports are generated as artifacts.
*API Automation*
Framework: Developed with Rest Assured for effective API testing.
Verification: API responses are validated using TestNG assertions for comprehensive coverage.
*Performance Testing*
Tool: JMeter is used to test the search functionality of n11.com.
Integration: JMeter test plans are included in the project as .jmx files.
Getting Started
To get started with this project, follow these steps:

**Prerequisites**
Java Development Kit (JDK) 8 or higher
Maven for dependency management
Git for version control
Clone the Repository
git clone https://github.com/egeacr/SeleniumRestAssuredJmeter.git
cd your-repo
Set Up Dependencies
Ensure you have Maven installed and run the following command to install the necessary dependencies:
mvn clean install

**Running Tests**
UI&API Tests: Execute UI tests using Maven:   mvn clean test -B


Performance Tests: Open JMeter and load the .jmx file located in the performance folder to run the performance tests.

**CI/CD Pipeline**
The project includes a GitHub Actions workflow that triggers on every merge to the main branch. The pipeline will:

