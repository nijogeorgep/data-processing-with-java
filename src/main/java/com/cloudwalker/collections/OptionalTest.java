/**
 *
 */
package com.cloudwalker.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author nijogeorgep
 *
 */
public class OptionalTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> listOfStrings =
                Arrays.asList("Mark", "Howard", "Anthony D'Cornian", "Nijo George P");

        Optional<String> largeString =
                listOfStrings.stream().filter(str -> str.length() > 10).findAny();
        largeString.ifPresent(System.out::println);

        Optional<String> veryLargeString =
                listOfStrings.stream().filter(str -> str.length() > 20).findAny();
        veryLargeString.ifPresent(System.out::println);

        // ---------------------------------------------------------------------------------------------------
        Optional<String> optional = Optional.empty();

        String str = "NIJO GEORGE PAYYAPPILLY";

        Optional<String> optnal = Optional.of(str);

        optnal.ifPresent(System.out::println);

        optnal = Optional.ofNullable(str);

        optnal.ifPresent(System.out::println);

    }

}
