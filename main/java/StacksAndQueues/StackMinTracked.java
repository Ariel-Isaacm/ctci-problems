package StacksAndQueues;

public class StackMinTracked {

    private class Node {
        Node previous;
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node current;

    public StackMinTracked(int val) {
        current = new Node(val, val);
    }

    public int min() {
        if (current != null) {
            return current.min;
        }
        return Integer.MIN_VALUE;
    }

    public void push(int val) {
        Node temp =  current;
        current = new Node(val, Math.min(temp.min, val));
        current.previous = temp;
    }

    public int peek() {
        if (current != null) {
            return current.val;
        }
        return Integer.MAX_VALUE;
    }

    public int pop() {
        if (current != null) {
            int currVal = current.val;
            current = current.previous;
            return currVal;
        }
        return Integer.MAX_VALUE;
    }
}
