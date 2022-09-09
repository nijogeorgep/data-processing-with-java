package com.cloudwalker.algorithms.leetcode;

import java.util.Comparator;
import java.util.function.Predicate;

public class BiggestTwoDigit {

    public static int Solution(String myString){
        return myString.chars() // Get the Stream from the input
                .filter(i -> i >= '0' && i <= '9')  // Filter non-numeric values
                .boxed()  // Convert to Integer to sort the Stream
                //.sorted(Comparator.reverseOrder()) // Sort in descending order
                .skip(1)  // Skip the maximum to get the second value
                .map(i -> i - '0') // Convert the ascii value to decimal
                .findFirst()  // Get the second maximum value
                .orElse(-1);  // If not exists, returns the -1 value
    }
    

    public static void main(String args[]){
        System.out.println("Result "+Solution("50559"));
    }
}
