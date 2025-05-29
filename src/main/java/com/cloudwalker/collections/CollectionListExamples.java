package com.cloudwalker.collections;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionListExamples {
    public static void main(String[] args) {
        // --- List with Stream Examples ---
        System.out.println("===============================================================================");
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Alice"); // Lists allow duplicates
        System.out.println("List of names: " + names); // Output: [Alice, Bob, Charlie, Alice]
        System.out.println("Name at index 1: " + names.get(1)); // Output: Bob

        // Using forEach (order may vary in parallel streams)
        names.stream().forEach( name -> System.out.println("Hello "+name));
        names.forEach(name -> System.out.println("Hello "+name));
        // Using forEachOrdered (guarantees order)
        names.stream().forEachOrdered(name -> System.out.println("GoodBye "+name));
        names.stream().forEachOrdered(name -> System.out.println("GoodBye "+name));

        // --- Filtering and Collecting to a new List ---
        // Get names starting with 'A'
        // @formatter:off
        List<String> filteredNames = names
                .stream()
                .filter(name -> name.startsWith("A"))
                .toList();
        // @formatter:on
        System.out.println("Names starting with 'A': " + filteredNames); // Output: [Alice, Alice]

        // --- Mapping and Collecting to a new List ---
        // Get the length of each name
        // @formatter:off
        List<Integer> nameLengths = names
                .stream()
                .map(String::length)
                .toList();
        // @formatter:on
        System.out.println("Lengths of names: " + nameLengths); // Output: [5, 3, 7, 5]

        // --- Distinct and Collecting to a Set ---
        // Get unique names
        // @formatter:off
        Set<String> uniqueNamesSet = names
                .stream()
                .distinct()
                .collect(Collectors.toSet());
        // @formatter:on
        System.out.println("Unique names: " + uniqueNamesSet); // Output: [Alice, Bob, Charlie] (order may vary)

        // --- Sorting and Collecting ---
        // Get names sorted alphabetically
        // @formatter:off
        List<String> sortedNames = names
                .stream()
                .distinct() // Remove duplicates
                .sorted()
                //.peek(value -> System.out.println("Sorting name: " + value)) // Debugging output
                .toList(); // Unique and sorted
        // @formatter:on
        System.out.println("Sorted Unique names: " + sortedNames); // Output: [Alice, Bob, Charlie]

        // --- Counting ---
        // Count names with length greater than 4
        // @formatter:off
        long countLongNames = names
                .stream()
                .distinct() // Remove duplicates
                .filter(name -> name.length() > 4)
                //.peek(value -> System.out.println("Filtering name: " + value)) // Debugging output
                .count();
        // @formatter:on
        System.out.println("Count of names with length > 4: " + countLongNames); // Output: 2 (Alice, Charlie)

        // --- Reduction (summing up lengths) ---
        // Calculate the total length of all names
        // @formatter:off
        int totalLength = names
                .stream()
                .distinct() // Remove duplicates
                .mapToInt(String::length)
                .sum();
        // @formatter:on
        System.out.println("Total length of unique names: " + totalLength); // Output: 15 (5 + 3 + 7)

        // --- Grouping by (collecting to a Map) ---
        // Group names by their first letter
        // @formatter:off
        Map<Character, List<String>> groupedByFirstLetter = names
                .stream()
                .distinct() // Remove duplicates
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        // @formatter:on
        System.out.println("Names grouped by first letter: " + groupedByFirstLetter);

        // --- Chaining multiple operations ---
        // Find the first unique name that starts with 'C' and convert to uppercase
        // @formatter:off
        Optional<String> firstUniqueCName = names
                .stream()
                .distinct() // Remove duplicates
                .filter(name -> name.startsWith("C"))
                .map(String::toUpperCase)
                .findFirst();
        // @formatter:on
        System.out.println("First unique name starting with 'C' in uppercase: " + firstUniqueCName.orElse("None")); // Output: CHARLIE

        // --- Reduction (summing up lengths) ---
        // Calculate the average of length from all names
        // @formatter:off
        double averageLength = names
                .stream()
                .distinct() // Remove duplicates
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        // @formatter:on
        System.out.println("Average length of unique names: " + averageLength); // Output: 5.0 (15 / 3)

        // Find the longest string
        // @formatter:off
        Optional<String> longestName = names
                .stream()
                .distinct() // Remove duplicates
                .max(Comparator.comparingInt(String::length));
        // @formatter:on

        // @formatter:off
        Optional<String> longestName2 = names
                .stream()
                .distinct() // Remove duplicates
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        // @formatter:on
        System.out.println("Longest name: " + longestName2.orElse("None")); // Output: Charlie


        // Get a stream of individual characters
        // @formatter:off
        List<Character> allCharacters = names
                .stream()
                .distinct() // Remove duplicates
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .toList();
        // @formatter:on
        System.out.println("All characters from unique names: " + allCharacters); // Output: [A, l, i, c, e, B, o, b, C, h, r, a, r, l]

        //Get All Authors and their books (Titles)
        // @formatter:off
        List<Author> authors = Arrays.asList(
                new Author("Author A", Arrays.asList(new Book("Book A1"), new Book("Book A2"))),
                new Author("Author B", Arrays.asList(new Book("Book B1"), new Book("Book B2"), new Book("Book B3")))
        );

        List<String> allBookTitles = authors
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getTitle)
                .toList();

        // @formatter:on
        System.out.println("All book titles from authors: " + allBookTitles); // Output: [Book A1, Book A2, Book B1, Book B2, Book B3]


        System.out.println("===============================================================================");

    }
}

class Book {
    String title;
    public Book(String title) { this.title = title; }
    public String getTitle() { return title; }
    @Override public String toString() { return title; }
}

class Author {
    String name;
    List<Book> books;
    public Author(String name, List<Book> books) { this.name = name; this.books = books; }
    public List<Book> getBooks() { return books; }
}