/**
 *
 */
package com.cloudwalker.algorithms.sort;

/**
 * @author nijogeorgep
 *
 */
public class InsertionSort {

    private static int[] insertionSortMe(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] >= current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }

    public static void main(String args[]) {
        int[] myArray = {7, 4, 5, 2, 0, 8, 1, 6, 3, 9};

        int[] resultArray = insertionSortMe(myArray);

        for (int val : resultArray) {
            System.out.print(val + " ");
        }

    }
}
