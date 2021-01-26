/**
 *
 */
package com.cloudwalker.algorithms.sort;

/**
 * @author nijogeorgep
 *
 */
public class SelectionSort {

    public static void main(String args[]) {
        int[] myArray = {7, 4, 5, 2, 0, 8, 1, 6, 3, 9};

        int[] resultArray = selectionSortMeMethodOne(myArray);

        for (int val : resultArray) {
            System.out.print(val + " ");
        }
    }

    private static int[] selectionSortMeMethodOne(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i] > myArray[j]) {
                    int temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        return myArray;
    }

    private static int[] selectionSortMeMethodTwo(int[] myArray) {
        for (int i = 0; i < myArray.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[j] < myArray[index]) {
                    index = j; //searching for lowest index
                }
            }
            int smallNum = myArray[index];
            myArray[index] = myArray[i];
            myArray[i] = smallNum;
        }
        return myArray;
    }
}
