/**
 *
 */
package com.cloudwalker.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nijogeorgep
 *
 */
public class CollectorsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Path shakespearePath = Paths.get("src/main/resources/files/words.shakespeare.txt");
        Path ospdPath = Paths.get("src/main/resources/files/ospd.txt");

        try (Stream<String> ospd = Files.lines(ospdPath);
             Stream<String> shakespear = Files.lines(shakespearePath);) {

            Set<String> scrabbleWords = ospd.collect(Collectors.toSet());
            Set<String> shakespearWords = shakespear.collect(Collectors.toSet());

            System.out.println("# Scrabble : " + scrabbleWords.size());
            System.out.println("# Shakespear : " + shakespearWords.size());

            int[] letterScores =
                    // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
                    {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

            // Function to Calculate the score
            Function<String, Integer> scoreBeforeBlank =
                    word -> word.toLowerCase().chars().map(letter -> letterScores[letter - 'a']).sum();

            // @formatter:off
            Map<Integer, List<String>> histogramOfWordsByScore = shakespearWords
                    .stream()
                    .filter(scrabbleWords::contains)
                    .collect(Collectors.groupingBy(scoreBeforeBlank));
            // @formatter:on

            System.out.println("# histogramOfWordsByScore : " + histogramOfWordsByScore.size());

            // @formatter:off
            histogramOfWordsByScore.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(entry -> -entry.getKey()))
                    .limit(3)
                    .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue()));
            // @formatter:on

            int[] scrabbleEndDistribution =
                    // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
                    {9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};

            // @formatter:off
            Function<String, Map<Integer, Long>> histogramWord = word -> word
                    .chars()
                    .boxed()
                    .collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));
            // @formatter:on

            // Function to find the number of repeated characters in String
            // @formatter:off
            Function<String, Long> noOfblanks = word -> histogramWord
                    .apply(word)
                    .entrySet().stream()
                    .mapToLong(entry -> Long.max(entry.getValue() - (long) scrabbleEndDistribution[entry.getKey() - 'a'], 0L))
                    .sum();
            // @formatter:on

            System.out.println("# of blanks for whizzing " + noOfblanks.apply("whizzing"));

            // Function compute the score of the word after excluding the repeated character in String
            // @formatter:off
            Function<String, Integer> scoreAfterBlank = word -> histogramWord
                    .apply(word)
                    .entrySet()
                    .stream()
                    .mapToInt(entry -> letterScores[entry.getKey() - 'a'] * Integer.min(entry.getValue().intValue(), scrabbleEndDistribution[entry.getKey() - 'a']))
                    .sum();
            // @formatter:on

            System.out.println("# SCORE1 for whizzing " + scoreBeforeBlank.apply("whizzing"));

            System.out.println("# SCORE2 for whizzing " + scoreAfterBlank.apply("whizzing"));

            // Computing the best word with blanks
            // @formatter:off
            shakespearWords.stream()
                    .filter(scrabbleWords::contains)
                    .filter(word -> noOfblanks.apply(word) <= 2)
                    .collect(Collectors.groupingBy(scoreAfterBlank))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(entry -> -entry.getKey()))
                    .limit(3)
                    .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue()));
            ;
            // @formatter:off

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
