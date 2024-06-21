# BoostDraftCodingAssignment

## Overview

This project is a console application that validates XML strings. The application reads an XML string passed as the first command line argument and prints `Valid` if the XML is well-formed according to the specified rules, otherwise it prints `Invalid`.

## Project Structure

The project consists of the following main components:

- **BoostDraftCodingAssignment.java**: The main class where the application is executed and test cases are run.
- **SimpleXmlValidator.java**: A utility class that contains the logic for validating the XML string.
- **TestCase.java**: A helper class used to store test cases for validating the `SimpleXmlValidator`.
- **README.md**: This file, providing an overview and instructions for the project.

## Getting Started

### Prerequisites

To build and run this project, you need to have the following installed:

- Java Development Kit (JDK) 8 or higher
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/BoostDraftCodingAssignment.git
    cd BoostDraftCodingAssignment
    ```

2. **Open the project in your IDE**:
    - If you are using VSCode, open the project directory.
    - If you are using another IDE, follow the IDE-specific instructions to open the project.

### Running the Application

1. **Compile the project**:
    - In VSCode or your IDE, compile the Java files.

2. **Run the main class**:
    - Execute the `BoostDraftCodingAssignment` main class. This will run the predefined test cases and print the results to the console.

### Running the Tests

The `main` method in `BoostDraftCodingAssignment.java` includes several test cases. You can modify or add more test cases to test different XML strings.

## Code Explanation

### SimpleXmlValidator

The `SimpleXmlValidator` class contains the core logic for validating XML strings. The method `determineXml(String xml)` returns `true` if the XML string is valid and `false` otherwise. It uses a stack to ensure that the XML tags are correctly nested and match.

### BoostDraftCodingAssignment

The `BoostDraftCodingAssignment` class contains the `main` method, which initializes and runs a list of test cases. Each test case is an instance of the `TestCase` class, containing the input XML string and the expected output.

### TestCase

The `TestCase` class is a simple data structure to hold the input XML string and the expected output (boolean value indicating if the XML string is valid).

## Example Usage

Here are some examples of XML strings and their validation results:

1. **Valid XML**:
    ```java
    "<Design><Code>hello world</Code></Design>"
    // Output: Valid
    ```

2. **Invalid XML (no closing tag for "People")**:
    ```java
    "<Design><Code>hello world</Code></Design></People>"
    // Output: Invalid
    ```

3. **Invalid XML (mismatched closing tags)**:
    ```java
    "<People><Design><Code>hello world</People></Code></Design>"
    // Output: Invalid
    ```

4. **Invalid XML (tag with space)**:
    ```java
    "<People age=\"1\">hello world</People>"
    // Output: Invalid
    ```

5. **Invalid XML (empty closing tag)**:
    ```java
    "</>"
    // Output: Invalid
    ```

## Contributions

Contributions are welcome! If you have suggestions or improvements, feel free to create a pull request or open an issue.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

