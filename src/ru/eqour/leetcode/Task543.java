package ru.eqour.leetcode;

public class Task543 {

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root)[1];
    }

    private int[] diameter(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{0, 0};
        }
        if (root.left != null && root.right == null) {
            int[] data = diameter(root.left);
            return new int[]{data[0] + 1, Math.max(data[0] + 1, data[1])};
        }
        if (root.right != null && root.left == null) {
            int[] data = diameter(root.right);
            return new int[]{data[0] + 1, Math.max(data[0] + 1, data[1])};
        }
        int[] result = new int[2];
        int[] ld = diameter(root.left);
        int[] rd = diameter(root.right);
        result[0] = Math.max(ld[0], rd[0]) + 1;
        result[1] = Math.max(Math.max(ld[0] + rd[0] + 2, ld[1]), rd[1]);
        return result;
    }

    // Definition for a binary tree node.
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
