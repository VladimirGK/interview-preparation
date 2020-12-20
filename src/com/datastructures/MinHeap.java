package com.datastructures;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    private static final int FRONT = 1;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        heap = new int[capacity];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void heapify(int pos) {
        int newValue = heap[pos];
        while (pos > 0 && newValue > heap[parent(pos)]) {
            heap[pos] = heap[parent(pos)];
            pos = parent(pos);
        }
        heap[pos] = newValue;
    }

    public void insert(int value) {
        if (isFull()) throw new IndexOutOfBoundsException("Heap is full");
        heap[size] = value;
        heapify(size);
        size++;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int extractMin() {
        int popped = heap[0];
        heap[0] = heap[size--];
        heapify(0);
        return popped;
    }
}
