package com.gujie1996.depthfirstsearch;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (root.left == null || root.right == null) {
            // 为空时，不能参与计算长度
            return 1 + Math.max(minLeft, minRight);
        }
        return 1 + Math.min(minLeft, minRight);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
}
