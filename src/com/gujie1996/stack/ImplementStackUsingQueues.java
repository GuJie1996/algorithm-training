package com.gujie1996.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }

    static class MyStack {

        Queue<Integer> existsQueue;
        Queue<Integer> emptyQueue;

        /** Initialize your data structure here. */
        public MyStack() {
            existsQueue = new LinkedList<>();
            emptyQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            existsQueue.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Integer lastOne = existsQueue.poll();
            while (existsQueue.peek() != null) {
                emptyQueue.offer(lastOne);
                lastOne = existsQueue.poll();
            }
            swapQueue();
            return lastOne;
        }

        /** Get the top element. */
        public int top() {
            Integer lastOne = null;
            while (existsQueue.peek() != null) {
                lastOne = existsQueue.poll();
                emptyQueue.offer(lastOne);
            }
            swapQueue();
            return lastOne;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return existsQueue.isEmpty();
        }

        void swapQueue() {
            Queue<Integer> temp = existsQueue;
            existsQueue = emptyQueue;
            emptyQueue = temp;
        }
    }

}
