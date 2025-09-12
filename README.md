# FPT University Lab Repository

Repository containing **Computer Science Discrete (CSD)** lab assignments for FPT University.

## Project Structure

```
src/
├── Utils/
│   ├── Menu.java          # Utility class for interactive menu
│   └── Utils.java         # Common utility functions
├── LetterAndCharacterCount/
│   ├── Lab.java           # Main class for character counting
│   └── Words.java         # Class for word and string processing
├── LinearSearch/
│   ├── Array.java         # Array class with linear search algorithm
│   └── Main.java          # Linear Search main program
├── ChangeBaseNumberSystem/
│   ├── Main.java              # Main program
│   ├── ConverterController.java # Controller handling user interface
│   └── ConverterService.java    # Service containing conversion logic
└── SolveEquation/
    ├── Main.java              # Main entry point
    ├── EquationController.java # Controller managing program flow
    └── EquationSolver.java     # Optimized equation solver with analysis
```

## Lab Assignments

### 1. **Letter and Character Count**
- **Description**: Count characters and words in text strings
- **Files**: `LetterAndCharacterCount/`
- **Features**: 
  - Count characters, words, lines
  - Text analysis functionality

### 2. **Linear Search**
- **Description**: Implementation and demonstration of linear search algorithm
- **Files**: `LinearSearch/`
- **Features**:
  - Generate random arrays
  - Search elements in arrays
  - Display search results

### 3. **Change Base Number System**
- **Description**: Convert between number systems (Binary, Decimal, Hexadecimal)
- **Files**: `ChangeBaseNumberSystem/`
- **Features**:
  - Convert between different number bases
  - Interactive menu interface
  - Input validation and error handling

### 4. **Solve Equation** ⭐ 
- **Description**: Solve linear and quadratic equations with coefficient analysis
- **Files**: `SolveEquation/`
- **Features**:
  - **Linear Equations**: Solve ax + b = 0
  - **Quadratic Equations**: Solve ax² + bx + c = 0
  - **Coefficient Analysis**: Identify even, odd, and perfect square numbers
  - **Optimized Architecture**: 
    - Unified solver class with integrated number analysis
    - Simplified controller with reduced code duplication
    - Enhanced user interface with better formatting
  - **Robust Input Validation**: Using Utils library functions
  - **Comprehensive Result Display**: Clear solution presentation

### 5. **Utils Package**
- **Description**: Utility library supporting all projects
- **Files**: `Utils/`
- **Features**:
  - Menu class for console interface
  - Common utility functions

## How to Run

### Compile and run each project:

```bash
# Linear Search
javac -d build src/LinearSearch/*.java src/Utils/*.java
java -cp build LinearSearch.Main

# Letter and Character Count  
javac -d build src/LetterAndCharacterCount/*.java src/Utils/*.java
java -cp build LetterAndCharacterCount.Main

# Change Base Number System
javac -d build src/ChangeBaseNumberSystem/*.java src/Utils/*.java  
java -cp build ChangeBaseNumberSystem.Main

# Solve Equation (NEW - Optimized)
javac -d build src/SolveEquation/*.java src/Utils/*.java
java -cp build SolveEquation.Main
```

### Alternative VS Code Run:
```bash
# For SolveEquation project
cd "d:\FPT\CSD\Lab"
javac -cp src src/SolveEquation/*.java src/Utils/*.java
java -cp build SolveEquation.Main
```

## Key Optimizations in SolveEquation

### **Architecture Improvements:**
- **Unified Class Structure**: Reduced from 4 classes to 3 classes
- **Integrated Number Analysis**: Combined equation solving and coefficient analysis in one solver
- **Simplified Controller**: Eliminated code duplication by using unified equation solving method
- **Enhanced Utils Integration**: Leveraged existing utility functions for robust input validation

### **Code Quality Enhancements:**
- **Method Signature Compliance**: Maintains exact method signatures as per requirements
- **Optimized Logic Flow**: Streamlined conditional statements and reduced complexity
- **Memory Efficiency**: Eliminated unnecessary object creation and improved list handling
- **Clean Code Principles**: Applied Single Responsibility Principle and DRY (Don't Repeat Yourself)

### **User Experience Improvements:**
- **Simplified Menu Interface**: Cleaner menu options and better user guidance
- **Enhanced Result Display**: Clear formatting for solutions and analysis results
- **Consistent Error Handling**: Unified approach to input validation and error messages

## System Requirements

- **Java**: JDK 17+ (uses features like switch expressions)
- **IDE**: NetBeans, IntelliJ IDEA, or VS Code with Java Extension
- **Build Tool**: Ant (build.xml included)

## Technical Specifications

### **SolveEquation Project Details:**
- **Linear Equation Solver**: `calculateEquation(float a, float b)` returns List<Float>
- **Quadratic Equation Solver**: `calculateQuadraticEquation(float a, float b, float c)` returns List<Float>
- **Return Value Convention**:
  - `null`: No solution exists
  - `Empty List`: Infinite solutions (linear equations only)
  - `List with values`: Contains the solution(s)
- **Number Analysis**: Automatic detection of even, odd, and perfect square coefficients
- **Input Validation**: Robust validation using Utils.getDoubleValue() method

### **Performance Optimizations:**
- **Reduced Memory Footprint**: Eliminated unnecessary intermediate objects
- **Faster Execution**: Streamlined conditional logic and unified processing
- **Code Maintainability**: Clear separation of concerns and simplified class hierarchy

## Author

- **Student**: LENOVO  
- **University**: FPT University
- **Course**: LAB211
- **Latest Update**: September 2025 - SolveEquation Project Optimization
