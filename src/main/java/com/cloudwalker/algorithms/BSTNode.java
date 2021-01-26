/**
 * <p>
 * <b>Searching a key</b>
 * <p>
 * <p>
 * To search a given key in Binary Search Tree, we first compare it with root, if the key is present
 * at root, we return root. If key is greater than root’s key, we recur for right subtree of root
 * node. Otherwise we recur for left subtree.
 * </p>
 */
package com.cloudwalker.algorithms;

/**
 * @author nijogeorgep
 */
public class BSTNode {

    BSTNode left, right;
    int data;

    /**
     *
     */
    public BSTNode(int data) {
        this.data = data;
    }

    /*
     * Inserts a node in the tree <p>Insertion of a key A new key is always inserted at leaf. We start
     * searching a key from root till we hit a leaf node. Once a leaf node is found, the new node is
     * added as a child of the leaf node.</p>
     */
    public void insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new BSTNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BSTNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    /*
     * finds a node in the tree
     *
     **/
    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    /*
     * prints the values in the tree - in-order traversal
     **/
    public void printInOrder() {
        // 1
        if (left != null) {
            left.printInOrder();
        }
        // 2
        System.out.println(data);
        // 3
        if (right != null) {
            right.printInOrder();
        }
    }

    /*
     * prints the values in the tree - pre-order traversal
     **/
    public void printPreOrder() {
        // 2
        System.out.println(data);
        // 1
        if (left != null) {
            left.printInOrder();
        }
        // 3
        if (right != null) {
            right.printInOrder();
        }
    }

    /*
     * prints the values in the tree - post-order traversal
     **/
    public void printPostOrder() {
        // 1
        if (left != null) {
            left.printInOrder();
        }
        // 3
        if (right != null) {
            right.printInOrder();
        }
        // 2
        System.out.println(data);
    }
}
