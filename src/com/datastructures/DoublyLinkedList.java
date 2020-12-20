package com.datastructures;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> implements Comparable<Node<T>> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

        @Override
        public int compareTo(Node<T> t) {
            String temp1 = this.toString();
            String temp2 = t.toString();
            return temp1.compareTo(temp2);
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        --size;
        if (isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail = tail.prev;
        --size;
        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;
        T data = node.data;
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        int i;
        Node<T> trav;
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++)
                trav = trav.next;
        } else {
            for (i = size - 1, trav = tail; i != index; i--)
                trav = trav.prev;
        }
        return remove(trav);
    }

    public boolean remove(Object obj) {
        Node<T> trav = head;
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next) {
                if (obj.equals((trav.data))) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next)
                if (trav.data == null) return index;
        } else {
            for (trav = head; trav != null; trav = trav.next)
                if (obj.equals(trav.data)) return index;
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    // Detect And Remove Loop In Linked List
    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;
        ptr1 = curr;
        while (true) {
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            if (ptr2.next == ptr1)
                break;
            ptr1 = ptr1.next;
        }
        ptr2.next = null;
    }

    // Merge Sort
    public void mergeSort() {
        System.out.print("Printing sorted linked list using merge sort --> ");
        mergeSort(head);
    }

    private Node<T> mergeSort(Node node) {
        if (node == null || node.next == null)
            return node;
        Node<T> second = split(node);
        node = mergeSort(node);
        second = mergeSort(second);
        return merge(node, second);
    }

    // Returns middle element
    private Node<T> split(Node<T> head) {
        Node<T> fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<T> temp = slow.next;
        slow.next = null;
        System.out.println(temp);
        return temp;
    }

    private Node<T> merge(Node first, Node second) {
        if (first == null)
            return second;
        if (second == null)
            return first;
        if (first.compareTo(second) == 1) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while (trav != null) {
            sb.append((trav.data + ", "));
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList();
        list.add(2);
        list.add(5);
        list.add(3);
        System.out.println(list);
        list.mergeSort();
        System.out.println(list);
    }
}
