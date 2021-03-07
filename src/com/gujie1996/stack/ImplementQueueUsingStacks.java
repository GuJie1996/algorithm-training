package com.gujie1996.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }

    static class MyQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStack.isEmpty()) {
                inToOut();
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (outStack.isEmpty()) {
                inToOut();
            }
            return outStack.isEmpty() ? 0 : outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }

        void inToOut() {
            while (!inStack.empty()) {
                Integer in = inStack.pop();
                outStack.push(in);
            }
        }
    }
}
