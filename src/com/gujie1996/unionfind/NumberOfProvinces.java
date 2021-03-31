package com.gujie1996.unionfind;

public class NumberOfProvinces {
    int count = 0;
    public static void main(String[] args) {
        int[][] isConnected = new int[][] {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
    }
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        int[] uf = new int[length];
        for (int i = 0; i < length; i++) {
            uf[i] = i;
            count++;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    // 有其他元素与自己相关，需要合并
                    union(uf, j, i);
                }
            }
        }
        return count;
    }
    public int find(int[] uf, int x) {
        int root = x;
        while (uf[root] != root) {
            root = uf[root];
        }
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
            uf[rootX] = rootY;
            count--;
        }
    }
}
