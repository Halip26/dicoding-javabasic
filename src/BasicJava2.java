public class BasicJava2 {
  public static void main(String args[]) {
    // 1. how to create variables
    // Data Types
    // How to declare in java
    // How to initilaze the variaves
    int marks; // bss or block started by symbol

    marks = 95;

    char grade = 'a';
    String result = "excellent";

    // upto 8 digits decimal
    float points = 23.66f;
    // upto 16 digits decimal
    double percentage = 95.6;

    byte a = 125;
    long b = 1000;

    System.out.println("Congratulations! you scored " + result
        + " results with a precentage of " + percentage + " with marks " + marks
        + " with grade " + grade + " with points " + points + " to " + a + " and " + b);

    // 2. Operators
    // a. arithematic operators

    int num1 = 51;
    int num2 = 14;

    // multiple initialize variables
    double sum, defference, multi, quotient, remainder;

    sum = num1 + num2;
    defference = num1 - num2;
    multi = num1 * num2;
    quotient = num1 / num2;
    remainder = num1 % num2;

    System.out.println("The sum is " + sum);
    System.out.println("The difference is " + defference);
    System.out.println("The multiplication is " + multi);
    System.out.println("The quotient is " + quotient);
    System.out.println("The remainder is " + remainder);

    // 3. Logical operator NOT, OR, AND, XOR
    // a. Unary NOT operator
    boolean passed = true;
    System.out.println("The negation of the boolean varibale passed is " + !passed);
    // b. pre/post increament operator

    // c. pre/post decrement operator
  }
}
