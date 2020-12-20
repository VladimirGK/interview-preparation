package com.datastructures;



import java.util.*;

public class BinarySearchTree <T extends Comparable<T>> {

    public enum TreeTraversalOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER;
    }

    private int nodeCount = 0;
    private Node root = null;

    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T elem) {
        if (contains(elem))
            return false;
        else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node node, T elem) {
        if (node == null) {
            node = new Node(null, null, elem);
        } else {
            if (elem.compareTo(node.data) < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    public boolean remove(T elem) {
        if (contains(elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {
        if (node == null) return null;
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            } else if (node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            } else {
                Node tmp = digLeft(node.right);
                node.data = tmp.data;
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    private Node digLeft(Node node) {
        Node cur = node;
        while(cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    private Node digRight(Node node) {
        Node cur = node;
        while(cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }
    public boolean contains(T elem) {
        return contains(root, elem);
    }
    private boolean contains(Node node, T elem) {
        if(node == null) return false;
        int cmp = elem.compareTo(node.data);
        if(cmp < 0) return contains(node.left, elem);
        else if (cmp > 0) return contains(node.right, elem);
        else return true;
    }
    public int height() {
        return height(root);
    }
    private int height(Node node) {
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right) + 1);
    }
    public Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER: return preOrderTraversal();
            case IN_ORDER: return inOrderTraversal();
            case POST_ORDER: return postOrderTraversal();
            case LEVEL_ORDER: return leverOrderTraversal();
            default: return null;
        }
    }
    private Iterator<T> preOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }
            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                return node.data;
            }
        };
    }
    private Iterator<T> inOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {
            Node trav = root;
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }
            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                while(trav != null && trav.left != null){
                    stack.push(trav.left);
                    trav = trav.left;
                }
                Node node = stack.pop();
                if(node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }
                return node.data;
            }
        };
    }
    private Iterator<T> postOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Stack<Node> stack1 = new Stack<>();
        final Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            Node node = stack1.pop();
            if(node != null) {
                stack2.push(node);
                if(node.left != null) stack1.push(node.left);
                if(node.right != null) stack1.push(node.right);
            }
        }
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack2.isEmpty();
            }
            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return stack2.pop().data;
            }
        };
    }
    private Iterator<T> leverOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !queue.isEmpty();
            }
            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) throw new ConcurrentModificationException();
                Node node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                return node.data;
            }
        };
    }
}
