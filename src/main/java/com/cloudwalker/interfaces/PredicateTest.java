/**
 *
 */
package com.cloudwalker.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author nijogeorgep
 *
 */
public class PredicateTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // create a list of strings
        List<String> names = Arrays.asList("ABI", "BINSON", "CLINDA", "DIBIN", "EVAN", "FRAGIL");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> predicate = (s) -> s.startsWith("E");

        // Consumer<String> pq = (s) -> s.endsWith("N");

        // Supplier<String> pqr= (s) -> s.endsWith("s");

        // Iterate through the list
        for (String st : names) {
            if (predicate.test(st)) {
                System.out.println(st);
            }
        }

        // Iterate using Stream
        names.stream().filter(predicate).forEach(System.out::println);

    }

}
