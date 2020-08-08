package StacksAndQueues;

public class StacksAndQueues {

    //3.1 Three in One: Describe how you could use a single array to implement three stacks.
    // If we're ok by having stacks with fixed size we could simply allocate 1/3 of the array size to each stack and
    // handle 3 different indexes for each stack.
    // If we're targeting to undefined size stack, we would have to increase the array size once the 1 stack starts
    // colliding with another stack. And this involves resizing the array and make a copy of the values of each stack
    // probably we would need  tto have a start/end indexes variables for each stack


    //3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
    //which returns the minimum element? Push, pop and min should all operate in 0(1) time.
    // ans in StackMinTracked.java

    //3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    //Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
    //threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
    //composed of several stacks and should create a new stack once the previous one exceeds capacity.
    //SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
    //(that is, pop ( ) should return the same values as it would if there were just a single stack).
    // ans  in SetOfStacks.java

    //3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.



}
