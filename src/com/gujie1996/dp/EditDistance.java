package com.gujie1996.dp;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("park", "spake"));
    }
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] states = new int[length1+1][length2+1];
        // word1前i个字符变为word2的前j个字符所需的最小路径
        // 初始状态（不考虑word1，直接插入）
        for (int i = 0; i <= length2; i++) {
            states[0][i] = i;
        }
        states[0][0] = 0;
        for (int i = 1; i <= length1; i++) {
            // 每进一个word1字符，如果要维持0的状态，必须要进行一次删除
            states[i][0] = states[i-1][0] + 1;
            for (int j = 1; j <= length2; j++) {
                states[i][j] = Integer.MAX_VALUE;
                // 4种状态转移方式，取最小值
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // 不动
                    states[i][j] = Math.min(states[i][j], states[i-1][j-1]);
                    // 相同的就不用考虑最后一个了，计算word1前i-1个转换成word2前j-1个的最小值就行
                    // 之前规划乱了，在考虑word1前i个字符输入之后可以进行的操作，没有站在宏观的角度去考虑两个字符串的关系
//                    if (j >= 2) {
//                        // 插入
//                        states[i][j] = Math.min(states[i][j], states[i-1][j-2] + 1);
//                    }
                } else {
                    // 删除
                    states[i][j] = Math.min(states[i][j], states[i-1][j] + 1);
                    // 替换
                    states[i][j] = Math.min(states[i][j], states[i-1][j-1] + 1);
                    // 插入
                    states[i][j] = Math.min(states[i][j], states[i][j-1] + 1);
                }
                // 也可以在本轮基础上插入
//                states[i][j] = Math.min(states[i][j], states[i][j-1] + 1);
            }
        }
        return states[length1][length2];
    }
}
