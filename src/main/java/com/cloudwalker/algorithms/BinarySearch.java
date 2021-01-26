/**
 * First Search = n
 * Second Search = n/2
 * Third Search = n/4
 * ....
 * (i-1)th Search = 2
 * (i)th Search = 1 =n/2(i-1)
 * <p>
 * find(item) = O(log 2 n)
 */
package com.cloudwalker.algorithms;

/**
 * @author nijogeorgep
 *
 *         https://en.wikipedia.org/wiki/Binary_search_algorithm
 */
public class BinarySearch {

    static int[] myArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29};


    public static boolean binarySearchIterative(int[] array, int x) {

        if (array.length < 0) {
            return false;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // int mid = (left + right) / 2;
            int mid = left + ((right - left) / 2);
            if (array[mid] == x) {
                return true;
            } else if (x < array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        if (array.length < 0) {
            return false;
        }

        if (left > right) {
            return false;
        }
        // int mid = (left + right) / 2;
        int mid = left + ((right - left) / 2);
        if (array[mid] == x) {
            return true;
        } else if (x < array[mid]) {
            return binarySearchRecursive(array, x, left, mid - 1);
        } else {
            return binarySearchRecursive(array, x, mid + 1, right);
        }
    }

    public static int binarySearchLeftMost(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] < x) {
                left = mid - 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    public static int binarySearchRightMost(int[] array, int x) {

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;

    }

    public static boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(array, x, 0, array.length - 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(binarySearchIterative(myArray, 9));
        System.out.println(binarySearchRecursive(myArray, 15));

    }

    // Input: Indices Range [l ... r)
    // Invariant: A[l] <= key and A[r] > key
    int GetRightPosition(int A[], int left, int right, int key) {
        int mid;

        while (right - left > 1) {
            mid = left + (right - left) / 2;

            if (A[mid] <= key)
                left = mid;
            else
                right = mid;
        }

        return left;
    }

    // Input: Indices Range (l ... r]
    // Invariant: A[r] >= key and A[l] > key
    int GetLeftPosition(int A[], int left, int right, int key) {
        int mid;

        while (right - left > 1) {
            mid = left + (right - left) / 2;

            if (A[mid] >= key)
                right = mid;
            else
                left = mid;
        }

        return right;
    }

    int CountOccurances(int A[], int size, int key) {
        // Observe boundary conditions
        int left = GetLeftPosition(A, -1, size - 1, key);
        int right = GetRightPosition(A, 0, size, key);

        // What if the element doesn't exists in the array?
        // The checks helps to trace that element exists
        return (A[left] == key && key == A[right]) ? (right - left + 1) : 0;
    }

}
