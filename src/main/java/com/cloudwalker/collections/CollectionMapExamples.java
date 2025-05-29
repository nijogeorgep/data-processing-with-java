package com.cloudwalker.collections;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionMapExamples {
    public static void main(String[] args) {
        // --- Map Example ---
        System.out.println("===============================================================================");
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 88);
        studentScores.put("David", 95); // David also got 95
        studentScores.put("Charlie", 72);
        studentScores.put("Alice", 98); // Overwrites the previous score for Alice
        System.out.println("Student scores: " + studentScores); // Output: {Alice=98, Charlie=72, Bob=88} (order may vary)
        System.out.println("Bob's score: " + studentScores.get("Bob"));

        //Iterating over the map
        studentScores.forEach((name, score) -> System.out.println(name + " scored " + score));

        // Filtering entries where score is greater than 80
        // @formatter:off
        Map<String, Integer> highScorers = studentScores
                .entrySet()
                .stream()
                .peek(entry -> System.out.println("Processing entry: " + entry))
                .filter(entry -> entry.getValue() > 80)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        // @formatter:on
        System.out.println("Students with scores greater than 80: " + highScorers); // Output: {Alice=98, Bob=88}

        // Count how many students got a score of 95
        // @formatter:off
        long count95 = studentScores
                .values()
                .stream()
                .filter(score -> score >= 95)
                .count();
        // @formatter:on
        System.out.println("Number of students with a score of 95: " + count95); // Output: 1 (David)


        // Convert Map entries to a custom object list
        // @formatter:off
        List<Student> studentList = studentScores
                .entrySet()
                .stream()
                .map(entry -> new Student(entry.getKey(), entry.getValue()))
                .toList();
        // @formatter:on
        System.out.println("List of students: " + studentList); // Output: List of Student objects

        Map<String, List<Student>> studentsAndSchools = new HashMap<>();
        // Adding students to schools
        studentsAndSchools.put("School B", List.of(new Student("Eve", 85, List.of("Maths")),
                new Student("Frank", 90,List.of("Physics"))));
        studentsAndSchools.put("School C", List.of(new Student("Grace", 80,List.of("Chemistry"))));
        studentsAndSchools.put("School D", List.of(new Student("Heidi", 75,List.of("Economics")),
                new Student("Ivan", 88,List.of("Physics"))));
        studentsAndSchools.put("School A", List.of(new Student("Alice", 98,List.of("Malayalam")),
                new Student("Bob", 88,List.of("English")),
                new Student("Charlie", 72,List.of("Physics")),
                new Student("David", 95,List.of("Maths"))));

        // Find the students and their schools
        // @formatter:off
        List<String> allStudents = studentsAndSchools
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Student::getName)
                .distinct()
                .toList();
        // @formatter:on
        System.out.println("All students from all schools: " + allStudents); // Output: List of unique student names

        // List of All Schools
        // @formatter:off
        List<String> allSchools = studentsAndSchools
                .keySet()
                .stream()
                .distinct()
                .toList();
        // @formatter:on
        System.out.println("All schools: " + allSchools); // Output: List of unique school names

        //List of Students and their Subjects
        // @formatter:off
        List<String> studentsAndSubjects = studentsAndSchools
                .values()
                .stream()
                .flatMap(List::stream)
                .map(student -> student.getName() + " - Subjects: " + String.join(", ", student.getSubjects()))
                .distinct()
                .toList();
        // @formatter:on
        System.out.println("Students and their subjects: " + studentsAndSubjects); // Output: List of students with their subjects

        // Schools with available subjects
        // @formatter:off
        Map<String, Set<String>> schoolSubjects = studentsAndSchools
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .flatMap(student -> student.getSubjects().stream())
                                .distinct()
                                .collect(Collectors.toSet())
                ));
        // @formatter:on
        System.out.println("Schools with available subjects: " + schoolSubjects); // Output: Map of schools with their subjects

        System.out.println("===============================================================================");

    }
}

class Student {
    String name;
    int score;
    List<String> subjects;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, List<String> subjects) {
        this.name = name;
        this.score = score;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}