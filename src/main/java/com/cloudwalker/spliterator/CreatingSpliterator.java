/**
 *
 */
package com.cloudwalker.spliterator;

import com.cloudwalker.spliterator.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author nijogeorgep
 *
 */
public class CreatingSpliterator {

    /**
     * @param args
     */
    public static void main(String... args) {
        Path filePath = Paths.get("files/person.txt");

        try (Stream<String> lines = Files.lines(filePath)) {

            Spliterator<String> lineSpliterator = lines.spliterator();

            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);
            Stream<Person> peopleStream = StreamSupport.stream(peopleSpliterator, false);

            peopleStream.forEach(System.out::println);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
