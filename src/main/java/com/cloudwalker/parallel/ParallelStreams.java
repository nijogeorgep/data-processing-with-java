/**
 *
 */
package com.cloudwalker.parallel;

// import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author nijogeorgep
 *
 */
public class ParallelStreams {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        // List<String> strings = new ArrayList<String>();
        // List<String> strings = new CopyOnWriteArrayList<>();
        // @formatter:off

        List<String> strings = Stream.iterate("+", s -> s + "+")
                .limit(1000)
                .parallel()
                //      .peek(s -> System.out.println(s + " processed in the thread " + Thread.currentThread().getName()))
                //      .forEach(s -> strings.add(s));
                .collect(Collectors.toList());

        // @formatter:on

        System.out.println("# of Strings : " + strings.size());
    }

}
