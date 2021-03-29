package com.gujie1996.dp;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] { 2,3,-2,4 };
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        // fmax(i)表示以第i个元素结尾的乘积最大子数组的乘积
        // fmin(i)表示以第i个元素结尾的乘积最小子数组的乘积
        // i>0; fmax(i) = fmax(i-1)*i; fmin(i) = fmin(i-1)*i
        // i<0; fmax(i) = fmin(i-1)*i; fmin(i) = fmax(i-1)*i
        int length = nums.length;
        int[] mins = new int[length];
        int[] maxs = new int[length];
        mins[0] = nums[0];
        maxs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val > 0) {
                // 和自身比较，万一前面的乘还不如不乘
                maxs[i] = Math.max(maxs[i-1]*val, val);
                mins[i] = Math.min(mins[i-1]*val, val);
            } else {
                maxs[i] = Math.max(mins[i-1]*val, val);
                mins[i] = Math.min(maxs[i-1]*val, val);
            }
        }
        int max = maxs[0];
        for (int maxi : maxs) {
            max = Math.max(maxi, max);
        }
        return max;
    }
}
