package org.example;

// simple generic stack using an array under the hood
public class Stack<T> {
    private final int MAX_SIZE = 10; // max capacity of stack
    private Object[] items; // array to hold stack items by Object since generics + arrays don't mix well
    private int top; // points to next free spot (size)

    public Stack() {
        items = new Object[MAX_SIZE];
        top = 0; // stack is empty at start
    }

    // add item to top of stack
    public void push(T item) {
        if (top >= MAX_SIZE) {
            System.out.println("Stack is full! Can't push: " + item);
            return;
        }
        items[top] = item;
        top++;
    }

    // remove and return top item
    @SuppressWarnings("unchecked")
    // this cast is safe as only T objects are kept in items[]
    public T pop() {
        if (top == 0) {
            System.out.println("Stack is empty! Nothing to pop.");
            return null;
        }
        top--;
        return (T) items[top]; // returns item at old top position
    }

    // return top item without removing it
    @SuppressWarnings("unchecked")
    // this cast is safe as only T objects are kept in items[]
    public T peek() {
        if (top == 0) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null;
        }
        return (T) items[top - 1]; // returns last added item without changing top
    }

    // return current num of items
    public int size() {
        return top; // top index equals num of elements
    }

    // clear the whole stack
    public void clear() {
        top = 0;
        System.out.println("Stack cleared.");
    }

    // true if stack empty
    public boolean isEmpty() {
        return top == 0;
    }

    // true if stack full
    public boolean isFull() {
        return top == MAX_SIZE;
    }
}
