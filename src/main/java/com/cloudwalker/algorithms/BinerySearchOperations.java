package com.cloudwalker.algorithms;

public class BinerySearchOperations {

    /**
     * Inserts a key in arr[] of given capacity.  n is current size of arr[].
     * This function returns n+1 if insertion is successful, else n.
     */
    static int insertSorted(int arr[], int n, int key, int capacity) {
        // Cannot insert more elements if n is already more than or equal to capcity
        if (n >= capacity) {
            return n;
        }
        int i;
        for (i = n - 1; (i >= 0 && arr[i] > key); i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = key;
        return (n + 1);
    }


    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    /**
     * Function to delete an element
     */
    static int deleteElement(int arr[], int n, int key) {
        // Find position of element to be deleted
        int pos = binarySearch(arr, 0, n - 1, key);

        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        // Deleting element
        int i;
        for (i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    public static void main(String args[]) {
        int arr[] = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = arr.length;
        int n = 6;
        int keyToInsert = 26;
        int keyToDelete = 70;

        System.out.print("\nArray Before Insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        // Inserting key
        System.out.print("\nInserting Key: " + keyToInsert);
        n = insertSorted(arr, n, keyToInsert, capacity);

        System.out.print("\nArray After Insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Deleting Key
        System.out.print("\nDeleting Key: " + keyToDelete);
        n = deleteElement(arr, n, keyToDelete);

        System.out.print("\nArray after deletion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

