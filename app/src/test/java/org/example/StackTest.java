package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushAndSize() {
        Stack<String> stack = new Stack<>();
        assertEquals(0, stack.size());

        stack.push("first");
        stack.push("second");

        assertEquals(2, stack.size());
    }

    @Test
    public void testPop() {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        String result = stack.pop();

        assertEquals("hello", result);
        assertEquals(0, stack.size());
    }

    @Test
    public void testPeek() {
        Stack<String> stack = new Stack<>();
        stack.push("peekMe");
        String peeked = stack.peek();

        assertEquals("peekMe", peeked);
        assertEquals(1, stack.size()); // peek doesn't remove
    }

    @Test
    public void testClear() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.clear();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testEmptyPopReturnsNull() {
        Stack<Integer> stack = new Stack<>();
        assertNull(stack.pop());
    }

    @Test
    public void testEmptyPeekReturnsNull() {
        Stack<Integer> stack = new Stack<>();
        assertNull(stack.peek());
    }

    @Test
    public void testIsEmptyAndIsFull() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        assertFalse(stack.isEmpty());
        assertTrue(stack.isFull());
    }

    @Test
    public void testPushWhenFullDoesNotIncreaseSize() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        int sizeBefore = stack.size();

        // trying to push when full - should print message and not add
        stack.push(100);
        int sizeAfter = stack.size();

        assertEquals(sizeBefore, sizeAfter);
    }
}
