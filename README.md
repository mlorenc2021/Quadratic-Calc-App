# Quadratic Equation Solver Android App

![](https://github.com/mlorenc2021/Quadratic-Calc-App/blob/master/download(1).gif)

This is a simple Android app that calculates the roots of a quadratic equation \( ax^2 + bx + c = 0 \). Users input the coefficients \(a\), \(b\), and \(c\), then tap a button to calculate and display the roots. The app handles real and imaginary roots and includes input validation.

## Features

- Input fields for coefficients \(a\), \(b\), and \(c\)
- Calculates roots using the quadratic formula
- Handles all cases:
  - Two distinct real roots
  - One real root (repeated)
  - Imaginary roots (non-real)
- Validates inputs with error messages
- Clear button to reset all inputs and outputs

## Technologies Used

- Java
- Android SDK
- AndroidX AppCompat
- XML layouts for UI

## Project Structure

- `MainActivity.java`  
  Implements the UI interaction, reads input values, validates inputs, computes the quadratic roots, and displays the results. Also manages button click listeners for calculation and clearing fields.

- `activity_main.xml`  
  Defines the app layout with EditText fields for input, TextViews for output, and Buttons for actions.
