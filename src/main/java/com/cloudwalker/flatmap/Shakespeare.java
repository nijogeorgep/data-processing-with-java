/**
 *
 */
package com.cloudwalker.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @author nijogeorgep
 *
 */
public class Shakespeare {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        final int[] scrabbleENscore =
                // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
                {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

        Set<String> shakespeareWords = Files.lines(Paths.get("src/main/resources/files/words.shakespeare.txt"))
                .map(word -> word.toLowerCase()).collect(Collectors.toSet());

        Set<String> scrabbleWords = Files.lines(Paths.get("src/main/resources/files/ospd.txt"))
                .map(word -> word.toLowerCase()).collect(Collectors.toSet());

        System.out.println("# words of shakespere : " + shakespeareWords.size());
        System.out.println("# words of scrabble : " + scrabbleWords.size());

        Function<String, Integer> score =
                word -> word.chars().map(letter -> scrabbleENscore[letter - 'a']).sum();

        ToIntFunction<String> intScore =
                word -> word.chars().map(letter -> scrabbleENscore[letter - 'a']).sum();

        System.out.println("Score of Hello :" + intScore.applyAsInt("hello"));

        // System.out.println("Score of Hello 2 :" + score.apply("hello"));

        String bestWord = shakespeareWords.stream().filter(word -> scrabbleWords.contains(word))
                .max(Comparator.comparing(score)).get();

        // String bestWord1 = shakespeareWords.stream().filter(word ->
        // scrabbleWords.contains(word)).max(Comparator.comparing(word ->
        // intScore.applyAsInt(word))).get();

        System.out.println("Best Word : " + bestWord);

        // System.out.println("Best Word 1 : " + bestWord1);

        IntSummaryStatistics summaryStatistics = shakespeareWords.stream()
                .filter(scrabbleWords::contains).mapToInt(intScore).summaryStatistics();

        System.out.println("Stats : " + summaryStatistics.toString());
    }

}
