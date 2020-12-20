package com.datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class StackList<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public StackList(T firstElem) {
        push(firstElem);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T elem) {
        list.addLast(elem);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
