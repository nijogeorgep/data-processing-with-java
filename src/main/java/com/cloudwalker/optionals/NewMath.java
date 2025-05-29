/**
 *
 */
package com.cloudwalker.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * @author nijogeorgep
 *
 */
public class NewMath {

    public static Optional<Double> sqrt(Double number) {
        return number > 0d ? Optional.of(Math.sqrt(number)) : Optional.empty();
    }

    public static Optional<Double> inv(Double number) {
        return number > 0d ? Optional.of(1d / number) : Optional.empty();
    }

    public static void main(String... args) {

        List<Double> results = new ArrayList<>();

        // @formatter:off
        ThreadLocalRandom.current().doubles(10_000)
                .boxed()
                .forEach(System.out::println);
        // @formatter:on


        // @formatter:off
        List<Double> doubles = DoubleStream.generate(() -> new Random().nextDouble())
                //.parallel()
                .boxed()
                .limit(1000)
                .toList();
        // @formatter:on
        System.out.println(doubles.size());

        // @formatter:off
        Function<Double, Stream<Double>> inSqrt = d -> NewMath.inv(d)
                .flatMap(NewMath::sqrt)
                .map(Stream::of)
                .orElseGet(Stream::empty);

        // @formatter:on
        results = doubles.stream().flatMap(inSqrt).toList();

        System.out.println(results.size());

    }

}
