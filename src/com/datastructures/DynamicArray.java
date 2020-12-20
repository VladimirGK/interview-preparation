package com.datastructures;

import java.util.Iterator;

//@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] data;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return data[index];
    }

    public void set(int index, T elem) {
        data[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++)
            data[i] = null;
        len = 0;
    }

    public void add(T elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] newData = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++)
                newData[i] = data[i];
            data = newData;
        }
        data[len++] = elem;
    }

    public void removeAt(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        for (int i = index; i < len; i++)
            data[i] = data[i++];
        len--;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < len; i++)
            if (data[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (data[i].equals(obj))
                return i;
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return data[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++)
                sb.append(data[i] + ", ");
            return sb.append(data[len - 1] + "]").toString();
        }
    }
}