package com.gujie1996.dp;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        // 10, 101
        // 9, 101
        // 2, 5, 7, 101
        // 重复子结构为后面的序列
        int length = nums.length;
        // 从每个数开始的最长递增子序列
        int[] maxLengths = new int[length];
        maxLengths[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            // 至少长度为1，即自身
            maxLengths[i] = 1;
            for (int j = i + 1; j < length; j ++) {
                if (nums[i] < nums [j]) {
                    // 遍历到比自己大的数
                    maxLengths[i] = Math.max(maxLengths[i], 1 + maxLengths[j]);
                }
            }
        }
        int maxLength = 1;
        for (int max : maxLengths) {
            maxLength = Math.max(maxLength, max);
        }
        return maxLength;
    }
}
