package com.gujie1996.dp;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
    }
    public int climbStairs(int n) {
        // 初始状态（结束状态） f(0) = f(1) = 1
        // 状态转移方程 f(n) = f(n-1) + f(n-2)
        // 保存状态
        int one_step_before = 1;
        int two_steps_before = 1;
        int all_ways = 1;
        for (int i = 2; i <= n; i++) {
            all_ways = two_steps_before + one_step_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
