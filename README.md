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
└── ChangeBaseNumberSystem/
    ├── Main.java              # Main program
    ├── ConverterController.java # Controller handling user interface
    └── ConverterService.java    # Service containing conversion logic
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

### 4. **Utils Package**
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
```

## System Requirements

- **Java**: JDK 17+ (uses features like switch expressions)
- **IDE**: NetBeans, IntelliJ IDEA, or VS Code with Java Extension
- **Build Tool**: Ant (build.xml included)

## Author

- **Student**: LENOVO
- **University**: FPT University
- **Course**: LAB211
