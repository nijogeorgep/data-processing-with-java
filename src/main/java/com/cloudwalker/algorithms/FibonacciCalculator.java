/**
 *
 */
package com.cloudwalker.algorithms;

import java.util.Scanner;

/**
 * @author nijogeorgep
 *
 */
public class FibonacciCalculator {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Enter number upto which Fibonacci Series  to print :");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();


        System.out.println("Fibonacci Series upto " + number + " numbers");
        for (int i = 1; i < number; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     * * Java program for Fibonacci number using recursion. * This program uses tail recursion to
     * calculate Fibonacci number for a given number * @return Fibonacci number
     */
    private static int fibonacci(int number) {
        if (number <= 1) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2); // tail recursion
    }

    /**
     * * Java program to calculate Fibonacci number using loop or Iteration. * @return Fibonacci
     * number
     */
    private static int fibonacci2(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        int num1 = 1, num2 = 1, fibonacci = 1;
        for (int i = 3; i <= number; i++) {
            fibonacci = num1 + num2;
            num1 = num2;
            num2 = fibonacci;
        }

        return fibonacci;
    }

}
