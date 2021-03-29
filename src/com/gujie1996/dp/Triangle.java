package com.gujie1996.dp;

import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> line = Collections.singletonList(2);
        triangle.add(line);
        line = Arrays.asList(3,4);
        triangle.add(line);
        line = Arrays.asList(6,5,7);
        triangle.add(line);
        line = Arrays.asList(4,1,8,3);
        triangle.add(line);
        System.out.println(new Triangle().minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        // 状态转移方程 f(x, y) = val + min(f(y+1, x), f(y+1, x+1))
        int size = triangle.size();
        int[][] minimums = new int[size + 1][];
        minimums[size] = new int[size + 1];
        for (int y = triangle.size() - 1; y >= 0 ; y--) {
            List<Integer> line = triangle.get(y);
            int lineSize = line.size();
            minimums[y] = new int[lineSize];
            for (int x = 0; x < lineSize; x++) {
                minimums[y][x] = line.get(x) + Math.min(minimums[y+1][x], minimums[y+1][x+1]);
            }
        }
        return minimums[0][0];
    }
}
