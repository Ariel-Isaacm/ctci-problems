package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
    private List<Stack<Integer>> stacks;
    private int fixedSize;
    private int currIndex = 0;

    public SetOfStacks(int fixedSize) {
        stacks = new ArrayList<Stack<Integer>>();
        this.fixedSize = fixedSize;
        stacks.add(new Stack<Integer>());
    }

    public void push(int val) {
        if (stacks.get(currIndex).size() == fixedSize) {
            currIndex++;
            stacks.add(new Stack<Integer>());
        }
        stacks.get(currIndex).push(val);
    }

    public int pop() {
        if (currIndex == 0 && stacks.get(currIndex).isEmpty()) return -1;
        if (stacks.get(currIndex).isEmpty()) {
            currIndex--;
        }
        return stacks.get(currIndex).pop();
    }


}
