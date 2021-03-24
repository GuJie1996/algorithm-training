package com.gujie1996.tree;

public class LowestCommonAncestorOfSearch {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(lowestCommonAncestor(root, left, right) == root);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
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
}
