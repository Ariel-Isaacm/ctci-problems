package StacksAndQueues;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> a;
    private Stack<Integer> b;

    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void add(int x) {
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(x);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    public int remove() {
        if (a.isEmpty()) return -1;
        return a.pop();
    }
}
