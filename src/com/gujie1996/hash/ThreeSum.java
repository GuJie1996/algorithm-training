package com.gujie1996.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[] { -1,0,1,2,-1,-4 };
        List<List<Integer>> results = threeSum.threeSum(nums);
        for (List<Integer> result : results) {
            System.out.println(result.toString());
        } 
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<> ();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 后面都是正数，不可能和为0
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                // 过滤相同组合
                continue;
            }
            // 双指针法
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > -nums[i]) {
                    // 和大于0，右指针左移
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    // 和小于0，左指针右移
                    left++;
                } else {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    // 继续寻找（去重）
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right+1]);
                }
            }
        }
        return results;
    }

}