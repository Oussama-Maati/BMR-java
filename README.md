# BMR Calculator Java Project

![Java Version](https://img.shields.io/badge/java-%3E%3D%2011-blue)
![JavaFX Version](https://img.shields.io/badge/javafx-%3E%3D%2011-blue)
![License](https://img.shields.io/badge/license-CC%20BY--NC-green)

This Java project is a Basal Metabolic Rate (BMR) calculator application that helps users estimate their BMR and daily calorie needs based on their age, gender, height, and weight. The application provides a graphical user interface (GUI) built using JavaFX.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Overview

This BMR calculator application is designed to provide users with an easy way to calculate their Basal Metabolic Rate, which represents the number of calories the body requires to maintain basic functions while at rest. The application uses the Mifflin-St Jeor equation to estimate BMR, taking into account the user's age, gender, height, and weight.

## Features

- User-friendly GUI using JavaFX.
- Input fields for entering age, gender, height, and weight.
- Calculation of BMR and daily calorie needs based on user input.
- Error handling for missing input and zero values.
- Clear button to reset input fields.
- Menu bar with an option to exit the application.

## Getting Started

To run the BMR calculator project on your local machine, follow these steps:

1. Ensure you have Java and JavaFX installed on your computer.
2. Clone this repository to your local machine.
3. Open the project in your preferred Java IDE.
4. Build and run the `BmrMain` class, which is the main entry point of the application.

## Usage

1. Launch the application, and the GUI window will appear.
2. Enter your age, gender, height, and weight in the input fields provided.
3. Click the "Calcul du BMR" (Calculate BMR) button to calculate the BMR and daily calorie needs.
4. If any input fields are empty, a message "Failed!" will be displayed in the BMR and calorie fields.
5. If any input fields contain the value 0, an error alert will be shown, indicating that the input values should not be zero.
6. Click the "Clear" button to reset all input fields and calculation results.
7. Use the menu bar to exit the application.

## Screenshots

![Screenshot 1](/src/main/resources/img/Capture.PNG)<br>
_Example screenshot of the BMR calculator application with input fields and results._

## Contributing

Contributions to this project are welcome! If you have any improvements or additional features to suggest, feel free to submit a pull request.

## License

This project is licensed under the [Creative Commons Attribution-NonCommercial (CC BY-NC) License](LICENSE), which means you are free to use, modify, and distribute the code for non-commercial purposes as long as you include the original license notice.
