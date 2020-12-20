package com.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueList<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public QueueList() {
    }

    public QueueList(T firstElem) {
        offer(firstElem);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }

    public void offer(T elem) {
        list.addLast(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
