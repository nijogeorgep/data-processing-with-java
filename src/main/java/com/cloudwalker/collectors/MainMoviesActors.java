/**
 *
 */
package com.cloudwalker.collectors;

import com.cloudwalker.collectors.model.Actor;
import com.cloudwalker.collectors.model.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nijogeorgep
 *
 */
public class MainMoviesActors {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String... args) throws IOException {

        Set<Movie> movies = new HashSet<>();

        Stream<String> moviesStream = Files.lines(Paths.get("src/main/resources/files/movies-mpaa.txt"));

        moviesStream.forEach((String line) -> {
            String[] elements = line.split("/");
            String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
            String releaseYear =
                    elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));

            if (releaseYear.contains(",")) {
                // with skip movies with a comma in their title
                return;
            }

            Movie movie = new Movie(title, Integer.parseInt(releaseYear));

            for (int i = 1; i < elements.length; i++) {
                String[] fullName = elements[1].split(",");
                String lastName = fullName[0].trim();
                String firstName = "";

                if (fullName.length > 1) {
                    firstName = fullName[1].trim();
                }

                Actor actor = new Actor(firstName, lastName);
                movie.addActors(actor);
            }

            movies.add(movie);

        });

        System.out.println("# Movies : " + movies.size());

        // # of Actors

        // @formatter:off
        long numOfActors = movies.stream()
                //.map(movie -> movie.actors()) // Stream<Set<Actor>>
                //.map(movie -> movie.actors().stream()) // Stream<Stream<Actor>> (Stream of Streams)
                .flatMap(movie -> movie.actors().stream()) //Stream<Actor> (flattening Stream of Stream with flatMap)
                //.collect(Collectors.toSet())
                .distinct()
                //.size();
                .count();
        // @formatter:on

        System.out.println("# of Actors : " + numOfActors);

        // # of actors that played in the greatest # of movies
        // @formatter:off
        // Map<Actor,Long> collect =
        Map.Entry<Actor, Long> mostViewedActor =
                movies.stream()
                        .flatMap(movie -> movie.actors().stream()) //Stream<Actor>
                        .collect(Collectors.groupingBy(
                                //actor ->actor, OR
                                Function.identity(),
                                Collectors.counting()))
                        .entrySet()
                        .stream() //Stream<Map.Entry<Actor,Long>>
                        .max(
                                //Comparator.comparing(entry -> entry.getValue()) OR
                                Map.Entry.comparingByValue()
                        )
                        .get();
        // @formatter:on

        System.out.println("Most Viewed Actor : " + mostViewedActor);

        // Actor that played in the greatest # of movies during a year
        // Map<releaseYear,Map<Actor,# of movies that year>>

        // @formatter:off
        Entry<Integer, Entry<Actor, AtomicLong>> collect = movies
                .stream()
                .collect(Collectors.groupingBy(movie -> movie.getReleaseYear(),
                        Collector.of(() -> new HashMap<Actor, AtomicLong>(), // supplier
                                (map, movie) -> {
                                    movie.actors().forEach(
                                            actor -> map.computeIfAbsent(actor, a -> new AtomicLong()).incrementAndGet());
                                }, // Accumulator
                                (map1, map2) -> {
                                    map2.entrySet().forEach(
                                            entry2 -> map1.merge(
                                                    entry2.getKey(),
                                                    entry2.getValue(),
                                                    (al1, al2) -> {
                                                        al1.addAndGet(al2.get());
                                                        return al1;
                                                    }
                                            )
                                    );
                                    return map1;
                                }, // combiner
                                Collector.Characteristics.IDENTITY_FINISH))
                ) //Map<Integer, HashMap<Actor, AtomicLong>>
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                                .entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue(Comparator.comparing(longVal -> longVal.get())))
                                .get())
                ) //Map<Integer, Map.Entry<Actor, AtomicLong>>
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Comparator.comparing(entry -> entry.getValue().get())))
                .get();
        //Map.Entry<Integer, Map<Actor, AtomicLong>>

        // @formatter:on

        System.out.println("# collect : " + collect);

        moviesStream.close();
    }

}
