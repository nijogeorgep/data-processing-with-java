/**
 *
 */
package com.cloudwalker.algorithms;

/**
 * @author nijogeorgep
 *
 */
public class BinarySearchTree {

    // Root of BST
    Node root;

    /**
     *
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * @param args Driver Program to test above functions
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // @formatter:off
        /*
         * Let us create following BST
         *       50
         *      /  \
         *     30  70
         *    / \  / \
         *   20 40 60 80
         */
        // @formatter:on

        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);
        tree.insert(50);
        tree.insert(90);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();


    }

    // This method mainly calls insertRec()
    /*
     * Inserts a node in the tree <p>Insertion of a key A new key is always inserted at leaf. We start
     * searching a key from root till we hit a leaf node. Once a leaf node is found, the new node is
     * added as a child of the leaf node.</p>
     */
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    private Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        /* return the (unchanged) node pointer */
        return root;
    }


    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }

    }

    /*
     * <b>Searching a key</b> <p> <p> To search a given key in Binary Search Tree, we first compare it
     * with root, if the key is present at root, we return root. If key is greater than root’s key, we
     * recur for right subtree of root node. Otherwise we recur for left subtree. </p>
     */
    // A utility function to search a given key in BST
    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }

        // val is greater than root's key
        if (root.key > key) {
            return search(root.left, key);
        } else {
            // val is less than root's key
            return search(root.right, key);
        }
    }

    // This method mainly calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    /* A recursive function to delete a new key in BST */
    private Node deleteRec(Node root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null) {
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        }

        // if key is same as root's key, then This is the node
        // to be deleted

        else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return null;
    }

    private int minValue(Node right) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    /* Class containing left and right child of current node and key value */
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

}
