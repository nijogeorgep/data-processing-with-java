/**
 *
 */
package com.cloudwalker.algorithms.sort;

/**
 * @author nijogeorgep
 *
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        // TODO Auto-generated method stub

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] myArray = {7, 4, 5, 2, 0, 8, 1, 6, 3, 9};

        quickSort(myArray);

    }

}
