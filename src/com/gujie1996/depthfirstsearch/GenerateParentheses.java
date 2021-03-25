package com.gujie1996.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gen(list, 0, 0, n, "");
        return list;
    }

    public void gen(List<String> list, int left, int right, int max, String result) {
        if (left == max && right == max) {
            // 左右括号用尽，返回结果
            list.add(result);
        }
        if (left < max) {
            // 左括号个数限制
            gen(list, left + 1, right, max, result + "(");
        }
        if (right < max && right < left) {
            // 右括号个数限制 + 右括号不能在前
            gen(list, left, right + 1, max, result + ")");
        }
    }

}
