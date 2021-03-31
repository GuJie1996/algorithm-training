package com.gujie1996.unionfind;

public class NumberOfIslands {

    int count = 0;

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int length1 = grid.length;
        int length2 = grid[0].length;
        int[] uf = new int[length1 * length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                // 并查集初始老大为自身
                int location = i * length2 + j;
                if (grid[i][j] == '1') {
                    uf[location] = location;
                    count++;
                    // 查询相邻的（上，左）如果是1，就尝试合并
                    if (j > 0 && grid[i][j-1] == '1') {
                        union(uf, location, location - 1);
                    }
                    if (i > 0 && grid[i-1][j] == '1') {
                        union(uf, location, location - length2);
                    }
                }
            }
        }
        return count;
    }

    // 找老大
    public int find(int[] uf, int x) {
        int root = x;
        // 老大是自身，就是最终的老大
        while (uf[root] != root) {
            root = uf[root];
        }
        // 路径压缩
        while (uf[x] != x) {
            int curRoot = uf[x];
            uf[x] = root;
            x = curRoot;
        }
        return root;
    }

    public void union(int[] uf, int x, int y) {
        int rootX = find(uf, x);
        int rootY = find(uf, y);
        if (rootX != rootY) {
            // 老大不一样，合并
            // 让 x的老大 做 y的老大 的小弟
            uf[rootX] = rootY;
            count--;
        }
    }
}
