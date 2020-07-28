package StackAndQueues;

import StacksAndQueues.StacksAndQueues;
import StacksAndQueues.StackMinTracked;
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
        assertEquals( 3, stack.min());
        stack.pop();
        assertEquals(6, stack.peek());
        assertEquals( 5, stack.min());
        stack.pop();
        assertEquals(5, stack.peek());
        assertEquals( 5, stack.min());
    }
}