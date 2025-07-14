package BinaryTree.Basics;

import BinaryTree.TreeNode;

public class BinaryTreeBasicQuestions {
    public int height(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = diameterOfBinaryTree(root.left, max);
        int right = diameterOfBinaryTree(root.right, max);
        max[0] = Math.max(max[0], 1 + left + right);
        return 1 + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = 0;
        left = Math.max(left, maxPathSum(root.left, max));
        int right = 0;
        right = Math.max(right, maxPathSum(root.right, max));

        max[0] = Math.max(max[0], root.data + left + right);
        return root.data + Math.max(left, right);
    }
}
