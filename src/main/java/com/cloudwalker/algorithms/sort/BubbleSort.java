/**
 *
 */
package com.cloudwalker.algorithms.sort;

/**
 * @author nijogeorgep
 *
 */
public class BubbleSort {

    private static int[] bubbleSortMe(int[] array) {
        int temp;
        int length = array.length;
        for (int k = 0; k < length - 1; k++) {
            // (length-k-1) is for ignoring comparisons of elements which have already been compared in
            // earlier iterations
            for (int i = 0; i < length - k - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String args[]) {
        int[] myArray = {7, 4, 5, 2, 0, 8, 1, 6, 3, 9};

        int[] resultArray = bubbleSortMe(myArray);

        for (int val : resultArray) {
            System.out.print(val + " ");
        }

    }
}
