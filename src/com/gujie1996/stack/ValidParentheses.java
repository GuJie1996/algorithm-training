package com.gujie1996.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("]"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("([)]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (Character c : s.toCharArray()) {
            Character mapChar = map.get(c);
            if (mapChar == null) {
                stack.push(c);
            } else if (stack.size() == 0 || !mapChar.equals(stack.pop())) {
                // 栈为空或者匹配不上左括号
                return false;
            }
        }
        return stack.size() == 0;
    }
}
