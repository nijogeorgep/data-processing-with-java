package com.cloudwalker.collections;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionSetExamples {
    public static void main(String[] args) {

        // --- Set Example ---
        System.out.println("===============================================================================");
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Charlie");
        uniqueNames.add("Alice"); // This will be ignored as Sets don't allow duplicates
        System.out.println("Set of unique names: " + uniqueNames); // Output: [Alice, Bob, Charlie] (order may vary)

        System.out.println("Contains 'Bob': " + uniqueNames.contains("Bob")); // Output: true

        // Iterating over the set
        uniqueNames.forEach(name -> System.out.println("Hello " + name));

        // Filtering names that start with 'A'
        // @formatter:off
        Set<String> filteredNames = uniqueNames
                .stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toSet());
        // @formatter:on
        System.out.println("Names starting with 'A': " + filteredNames); // Output: [Alice]

        // Mapping names to their lengths
        // @formatter:off
        Set<Integer> nameLengths = uniqueNames
                .stream()
                .map(String::length)
                .collect(Collectors.toSet());
        // @formatter:on
        System.out.println("Lengths of names: " + nameLengths); // Output: [3, 5, 7] (order may vary)

        // Sorting names and collecting to a List
        // @formatter:off
        List<String> sortedNames = uniqueNames
                .stream()
                .sorted()
                .toList();
        // @formatter:on
        System.out.println("Sorted names: " + sortedNames); // Output: [Alice, Bob, Charlie] (sorted order)

        System.out.println("===============================================================================");
    }
}
