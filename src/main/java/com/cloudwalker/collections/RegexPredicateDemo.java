package com.cloudwalker.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexPredicateDemo {

    public static void main(String args[]){
        // Input list
        List<String> emails = Arrays.asList("nijo@example.com", "george@yahoo.com",
                "payyappilly@google.com", "elenthikkara@example.com", "ernakulam@outlook.com");

        Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
        Predicate<String> emailFilter2 = Pattern.compile("^(.+)@outlook.com$").asPredicate();

        List<String> filteredEmails = emails.stream().filter(emailFilter).collect(Collectors.toList());
        List<String> filteredEmails2 = emails.stream().filter(emailFilter.negate()).collect(Collectors.toList());
        List<String> filteredEmails3 = emails.stream().filter(emailFilter.or(emailFilter2)).collect(Collectors.toList());

        filteredEmails.forEach(System.out::println);
        filteredEmails2.forEach(System.out::println);
        filteredEmails3.forEach(System.out::println);
    }
}
