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
        Function<Integer, Double> centigradeToFahrenheitInt = x -> new Double((x * 9 / 5) + 32);

        // String to an integer
        Function<String, Integer> stringToInt = x -> Integer.valueOf(x);

        // Length of a String
        Function<String, Integer> stringLength = x -> x.length();

        // tests
        System.out.println("Centigrade to Fahrenheit: " + centigradeToFahrenheitInt.apply(32));
        System.out.println("String to Int: " + stringToInt.apply("4"));
        System.out.println("Length of String :" + stringLength.apply("NIJO GEORGE PAYYAPPILLY"));
    }

}
