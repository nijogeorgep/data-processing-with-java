/**
 *
 */
package com.cloudwalker.interfaces;

/**
 * @author nijogeorgep
 *
 */
public class SquareTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a = 10, b = 20;

        // lambda expression to define the calculate method
        Square square = (int x, int y) -> x * y;

        System.out.println(square.calculate(a, b));
    }

}
