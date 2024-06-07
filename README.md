
# The Internet

## Project Overview

Welcome to the The Internet project! This project aims to provide a robust framework for automating web UI tests using Selenium WebDriver, TestNG, and other essential tools. The project is designed to be modular, scalable, and easy to maintain.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Jenkins Integration](#jenkins-integration)
- [Contributing](#contributing)
  

## Technologies Used

- **Java**: Programming language used for writing tests.
- **Selenium WebDriver**: Browser automation tool.
- **TestNG**: Testing framework.
- **WebDriverManager**: Manages browser drivers.
- **Log4j**: Logging framework.
- **OpenCSV**: Library for reading and writing CSV files.
- **Apache Commons IO**: Utility library for IO operations.
- **Maven**: Build and dependency management tool.

## Project Structure

- `src/main/java`: Contains the main Java code.
- `src/test/java`: Contains the test code.
- `src/test/resources/TestSuites`: Contains TestNG suite XML files.
- `pom.xml`: Maven project file.

## Setup Instructions

### Prerequisites

- Java JDK 21 or higher
- Maven 3.6 or higher
- Git
- Web browser (e.g., Chrome, Firefox)

### Clone the Repository

\`\`\`bash
git clone https://github.com/AleksandrosV/Java_automation.git
cd Java_automation/AutomationWebUI
\`\`\`

### Configure Maven

Ensure you have Maven installed and properly configured. You can verify this by running:

\`\`\`bash
mvn -v
\`\`\`

## Running Tests

To clean the project and run tests, execute the following Maven command:

\`\`\`bash
mvn clean test
\`\`\`

This command will compile the project, execute the tests defined in `FullUITestSuite.xml`, and generate reports.

## Jenkins Integration

To integrate this project with Jenkins:

1. **Create a New Jenkins Job**:
   - Go to Jenkins dashboard and create a new Freestyle project.

2. **Configure Source Code Management**:
   - Select Git and provide the repository URL: `https://github.com/AleksandrosV/Java_automation.git`
   - Set the branch to `main` or any specific branch you are working on.

3. **Add Build Step**:
   - Add a Windows batch command or Shell script (depending on your Jenkins server) with the following commands:

   \`\`\`bash
   cd AutomationWebUI
   mvn clean test
   \`\`\`

4. **Post-build Actions**:
   - Add "Publish TestNG Results" and configure the pattern to `**/AutomationWebUI/target/surefire-reports/testng-results.xml`.

## Contributing

We welcome contributions! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature/your-feature-name`.
5. Submit a pull request.

Please make sure to update tests as appropriate.
