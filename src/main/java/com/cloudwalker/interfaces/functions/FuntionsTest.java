/**
 *
 */
package com.cloudwalker.interfaces.functions;

import java.util.function.Function;

/**
 * @author nijogeorgep
 *
 */
public class FuntionsTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // convert centigrade to fahrenheit
        Function<Integer, Double> centigradeToFahrenheitInt = x -> ((double) (x * 9) / 5) + 32;

        // String to an integer
        Function<String, Integer> stringToInt = Integer::valueOf;

        // Length of a String
        Function<String, Integer> stringLength = String::length;

        // tests
        System.out.println("Centigrade to Fahrenheit: " + centigradeToFahrenheitInt.apply(20));
        System.out.println("String to Int: " + stringToInt.apply("4"));
        System.out.println("Length of String :" + stringLength.apply("NIJO GEORGE PAYYAPPILLY"));
    }

}
