/**
 *
 */
package com.cloudwalker.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nijogeorgep
 *
 */
public class StreamTest {

    private static int sumStream(List<Integer> list) {
        return list.stream().filter(i -> i > 5).mapToInt(i -> i).sum();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(sumStream(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));

        Stream<String> stringStream = Stream.of("IN", "THE", "END", ",", "IT", "IS", "NOTHING");

        // Stream.collect

        List<String> sentence = stringStream.collect(Collectors.toList());

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            myList.add(i);

        // sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        // Stream.filter

        Stream<Integer> highNums = sequentialStream.filter(number -> number > 90);

        highNums.forEach(number -> System.out.println("Numbers greater than 90 = " + number));

        // parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        // Stream.filter

        Stream<Integer> highNums1 = parallelStream.filter(number -> number > 90);

        highNums1.forEach(number -> System.out.println("Numbers greater than 90 = " + number));

        // Stream.map

        System.out.println(sentence.stream().map(names -> {
            return names.toUpperCase();
        }).collect(Collectors.toList()));

        // System.out.println(stringStream.filter(s -> s.length() >
        // 2).collect(Collectors.toList()));
        System.out.println(sentence.stream().filter(s -> s.length() > 2).collect(Collectors.toList()));

        // Stream.sorted

        Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
        List<String> reverseSorted =
                names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSorted); // [ef, d, aBc, 123456]

        Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
        List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
        System.out.println(naturalSorted); // [123456, aBc, d, ef]

        // Stream.flatmap
        Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("NIJO", "GEORGE"),
                Arrays.asList("DAVID", "DIBIN"), Arrays.asList("ANIL", "THADATHIPARAMBIL"));
        // flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());

        flatStream.forEach(System.out::println);

    }

}
