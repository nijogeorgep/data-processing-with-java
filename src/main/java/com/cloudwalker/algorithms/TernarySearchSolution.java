package com.cloudwalker.algorithms;

public class TernarySearchSolution {

    private static int ternaryRecursive(int[] array, int left, int right, int x) {
        if (right >= left) {

            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (array[mid1] == x) {
                return mid1;
            }

            if (array[mid2] == x) {
                return mid2;
            }

            if (x < array[mid1]) {
                return ternaryRecursive(array, left, mid1 - 1, x);
            } else if (x > array[mid2]) {
                return ternaryRecursive(array, mid2 + 1, right, x);
            } else {
                return ternaryRecursive(array, mid1 + 1, mid2 - 1, x);
            }
        }
        return -1;

    }

    private static int ternaryRecursive(int[] array, int x) {
        return ternaryRecursive(array, 0, array.length - 1, x);
    }

    public static void main(String args[]) {

        int[] myArray = {5, 8, 1, 3, 2, 7, 4, 6, 9, 0};

        System.out.println(ternaryRecursive(myArray, 4));
    }
}
