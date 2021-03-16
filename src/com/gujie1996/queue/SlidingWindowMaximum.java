package com.gujie1996.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};
        int[] maxValues = new Solution().maxSlidingWindow(nums, 3);
        for (int i : maxValues) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> queue = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                // 队首元素不在窗口内出队
                if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                    queue.pollFirst();
                }
                while (!queue.isEmpty()) {
                    if (nums[queue.peekLast()] <= nums[i]) {
                        // 当前元素比队尾大，队尾永远不会是最大值，丢弃队尾
                        // 这样保证了队列是单调递减，最大值永远是队首
                        queue.pollLast();
                    } else {
                        break;
                    }
                }
                queue.offerLast(i);
                if (i >= k - 1) {
                    // 每次操作后，队首最大，将队首记录
                    result[i - k + 1] = nums[queue.peekFirst()];
                }
            }
            return result;
        }
    }

}
