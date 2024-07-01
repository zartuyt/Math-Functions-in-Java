# Mathematical Functions Library: The diagram below shows all the classes that I created, and the parent-child relationship
between them.

## Overview

This project is a Java library for representing and manipulating various mathematical functions. It includes support for simple functions like constants and polynomials, composite functions, and trigonometric functions. The library allows for operations such as addition, subtraction, multiplication, division, and differentiation of these functions. I have created this project as a homeowork for my OOP class. 

## Features

- Abstract class `Function` to represent a generic mathematical function.
- Abstract class `SimpleFunction` for simple functions such as constants and polynomials.
- Abstract class `CompositeFunction` for composite functions of the form \( c \cdot f(g(x)) \).
- Abstract class `TrigonometricFunction` for trigonometric functions.
- Concrete classes for:
  - Constants
  - Polynomials
  - Exponential functions
  - Logarithmic functions
  - Natural logarithm
  - Sine, cosine, tangent, and cotangent functions
  - Complex functions representing the sum, difference, product, or quotient of two functions

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE or a text editor and terminal

### Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/MathFunctionsLibrary.git
    cd MathFunctionsLibrary
    ```

2. Open the project in your preferred Java IDE.

3. Compile the Java files:
    ```sh
    javac -d bin src/*.java
    ```

### Usage

Here is an example of how to use the library to create and manipulate mathematical functions:

```java
public class Main {
    public static void main(String[] args) {
        Function f = new Polynomial(new double[]{1, 0, 3}); // 3x^2 + 1
        Function g = new Constant(5); // 5

        Function sum = f.add(g);
        Function product = f.multiply(g);
        Function derivative = f.derivative();

        System.out.println("Function f: " + f);
        System.out.println("Function g: " + g);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Derivative of f: " + derivative);
    }
}
