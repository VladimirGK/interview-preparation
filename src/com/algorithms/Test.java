package com.algorithms;

import java.util.Stack;

public class Test {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    boolean isValidBST(Node root) {
        Stack<Node> stack = new Stack<>();
        double inorder = -1;
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

    static class BST {
        Node root;

        public BST(Node root) {
            this.root = root;
        }

        public void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.println(root.left);
        }

    }

    public static void main(String[] args) {

    }
}
