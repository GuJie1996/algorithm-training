package com.gujie1996.recursion;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[] { 2,2,1,1,1,2,2 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = majorityElement(Arrays.copyOf(nums, nums.length/2));
        int right = majorityElement(Arrays.copyOfRange(nums, nums.length/2, nums.length));
        if (left == right) {
            return left;
        }
        int count = 0;
        for (int val : nums) {
            if (val == left) {
                count ++;
            }
        }
        return count > nums.length/2 ? left : right;
    }

}
