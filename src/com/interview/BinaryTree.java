package com.interview;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
    private class Node {
        int data;
        Node left, right;

        public Node(int elem) {
            this.data = elem;
            this.left = null;
            this.right = null;
        }
    }

    // Algorithm for checking if binary tree is BST
    public boolean isValidBST(Node root) {
        Stack<Node> stack = new Stack<>();
        int inorder = -Integer.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.data <= inorder) return false;
            inorder = root.data;
            root = root.right;
        }
        return true;
    }

    // If binary tree is BST, easier way with recursion
    private void isBST(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        isBST(root.left, list);
        list.add(root.data);
        isBST(root.right, list);
    }

    public boolean isValid(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        isBST(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    // How do you find the depth of a binary tree
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Inorder Tree Traversal
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // Preorder Tree Traversal
    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Tree Traversal
    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    // Print all leaf nodes
    public void printLeafs(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.println(root.data);
        printLeafs(root.left);
        printLeafs(root.right);
    }

    // Check if a binary tree is balanced or not
    public boolean isBalanced(Node root) {


        return Math.abs(height(root.left) - height(root.right)) > 1;
    }

    // create BST with integer array
    public void createBST(int[] arr) {
        Node root = null;
        for (int key : arr) {
            if (root != null) {
                insert(root, key);
            } else {
                root = new Node(key);
            }
        }
    }

    public Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        if (key > root.data) {
            root.right = insert(root.right, key);
        }
        return root;
    }

}
