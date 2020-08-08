package StackAndQueues;

import StacksAndQueues.StacksAndQueues;
import StacksAndQueues.StackMinTracked;
import StacksAndQueues.MyQueue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StacksAndQueuesTest {
    // no need for a test for 3.1
    static StacksAndQueues solution;

    @BeforeAll
    static void setUp() {
        solution = new StacksAndQueues();
    }

    @Test
    void testMinInStack() {
        StackMinTracked stack = new StackMinTracked(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);
        assertEquals(7, stack.peek());
        assertEquals(3, stack.min());
        stack.pop();
        assertEquals(3, stack.peek());
        assertEquals(3, stack.min());
        stack.pop();
        assertEquals(6, stack.peek());
        assertEquals(5, stack.min());
        stack.pop();
        assertEquals(5, stack.peek());
        assertEquals(5, stack.min());
    }

    @Test
    void testMyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);

        for (int i = 1; i < 7; i++) {
            assertEquals(i, myQueue.remove());
        }
        assertEquals(-1, myQueue.remove());
    }
}