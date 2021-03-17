package com.gujie1996.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static void main (String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[] { 2,7,11,15 };
        int target = 9;
        for (int i : twoSum.twoSum(nums, target)) {
            System.out.print(nums[i] + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            int surplus = target - nums[i];
            if (map.containsKey(surplus))  {
                results[0] = map.get(surplus);
                results[1] = i;
                return results;
            }
            map.put(nums[i], i);
        }
        return results;
    }

}