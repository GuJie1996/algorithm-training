package com.gujie1996.queue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    static class KthLargest {

        PriorityQueue<Integer> minHeap;
        int k = 0;

        public KthLargest(int k, int[] nums) {
            // size为k的小顶堆
            this.k = k;
            minHeap = new PriorityQueue<>(k);
            for (int i : nums) {
                addVal(i);
            }
        }

        public int add(int val) {
            addVal(val);
            return minHeap.peek();
        }

        public void addVal(int val) {
            if (minHeap.size() >= k) {
                int min = minHeap.peek();
                if (val < min) {
                    return;
                } else {
                    minHeap.poll();
                }
            }
            minHeap.offer(val);
        }
    }

}
