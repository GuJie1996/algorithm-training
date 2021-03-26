package com.gujie1996.pruning;

import java.util.*;

public class NQueens {

    Set<Integer> col = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();
    List<List<String>> lists = new ArrayList<>();

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(String.join(",", list));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        gen(n, 0, new ArrayList<>());
        return lists;
    }

    public void gen(int n, int row, List<String> list) {
        if (row >= n) {
            List<String> result = new ArrayList<>();
            result.addAll(list);
            lists.add(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            Integer pieInt = row + i;
            Integer naInt = row - i;
            if (col.contains(i) || pie.contains(pieInt) || na.contains(naInt)) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            String curLocation = builder.toString();
            list.add(curLocation);
            col.add(i);
            pie.add(pieInt);
            na.add(naInt);
            gen(n, row + 1, list);
            // 还原现场
            list.remove(row);
            col.remove(i);
            pie.remove(pieInt);
            na.remove(naInt);
        }
    }
}
