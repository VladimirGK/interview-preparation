package com.interview;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTasks {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    class MyLinkedList {
        Node head;
    }

    // Find the middle element of a singly linked list in one pass
    static void getMiddle(LinkedList list) {
        int size = list.size();
        int i = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (i == list.size() / 2) {
                System.out.println(list.get(i));
                break;
            }
            i++;
            iterator.next();
        }
    }

    // Find the 3rd element from last in a single pass
    static int get3rdElement(Node head) {
        //Node current = head;
        //Node middle = head;
        //while(current.next() != null) {
        //   current = current.next.next;
        //   middle = middle.next;
        // }
        //return middle.data;
        return -1;
    }

    // Does a linked list has a cycle
    static boolean isCyclic(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Reverse a linked list
    static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        // 1->2->3->4 ---> 4->3->2->1
        // 1) next = 2, curr.next = null, prev = 1, curr = 2
        // 2) next = 3, curr.next = 1, prev = 2, curr = 3
        // 3) next = 4, curr.next = 2, prev = 3, curr = 4
        // 4) next = null, curr.next = 3, prev = 4, curr = null
        // node = prev = 4

        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(9);
        getMiddle(list);

    }
}

