package com.gujie1996.tree;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public static void main (String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(isValidBST(root));
    }

    public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

    public static boolean isValidBST(TreeNode root) {
        // 中序遍历 || 递归左小右大
        Stack<TreeNode> stack = new Stack<>();
        Integer preValue = null;
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 比较
            if (preValue != null && preValue.intValue() >= root.val) {
                return false;
            }
            preValue = root.val;
            root = root.right;
        }
        return true;
    }
    
}