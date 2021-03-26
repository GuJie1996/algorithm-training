package com.gujie1996.pruning;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {

    Set<Integer> col = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    int count = 0;

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        dfs(n, 0);
        return count;
    }

    public void dfs(int n, int row) {
        if (row >= n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            Integer pieInt = row - i;
            Integer naInt = row + i;
            if (col.contains(i) || pie.contains(pieInt) || na.contains(naInt)) {
                continue;
            }
            col.add(i);
            pie.add(pieInt);
            na.add(naInt);
            dfs(n, row + 1);
            col.remove(i);
            pie.remove(pieInt);
            na.remove(naInt);
        }
    }
}
