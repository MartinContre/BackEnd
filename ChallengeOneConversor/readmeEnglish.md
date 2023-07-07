# Unit Conversion Project

This Java project allows you to perform unit conversions in three categories: Currency, Temperature, and Length. It provides a graphical user interface to select the conversion type and perform the conversions interactively.

## Features
- Welcome screen that prompts the user for confirmation to start.
- Menu for selecting the type of unit to convert: Currency, Temperature, or Length.
- Interactive windows for entering conversion values, selecting the initial and target units, and performing the conversions.
- Option to clear the input field.
- Option to go back to the type selection menu.
- Option to close the application entirely.
- Uses the JOptionPane library to display dialog windows.
- Requires a valid API key provided by ExchangeRate-API to perform currency conversions.

## Configuration
1. Obtain a valid API key from ExchangeRate-API.
2. Inside config.json, in the root of the project, modify the following:
```
    {
        "API_KEY": "YOUT_API_KEY"
    }
```
Replace YOUR_API_KEY with your API key obtained from ExchangeRate-API.

## System Requirements
- Java JDK 8 or higher.

## Execution
1. Compile the project using the following command:
   - javac Main.java
2. Run the project with the following command:
   - java Main
3. A welcome window will be displayed. Select "Yes" to proceed.
4. A new window will open to select the type of unit to convert (Currency, Temperature, or Length).
5. Select the unit type, and a window will open to enter the conversion values and perform the conversions. 
6. Follow the on-screen instructions and use the provided buttons to interact with the application.