package ru.eqour.leetcode;

public class Task513 {

    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValueWithDepth(root)[1];
    }

    private int[] findBottomLeftValueWithDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{0, root.val};
        }
        if (root.left != null && root.right == null) {
            int[] left = findBottomLeftValueWithDepth(root.left);
            return new int[]{left[0] + 1, left[1]};
        }
        if (root.right != null && root.left == null) {
            int[] right = findBottomLeftValueWithDepth(root.right);
            return new int[]{right[0] + 1, right[1]};
        }
        int[] left = findBottomLeftValueWithDepth(root.left);
        int[] right = findBottomLeftValueWithDepth(root.right);
        if (left[0] >= right[0]) {
            return new int[]{left[0] + 1, left[1]};
        } else {
            return new int[]{right[0] + 1, right[1]};
        }
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
