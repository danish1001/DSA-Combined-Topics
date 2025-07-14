package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class isValidBST {
    public boolean isValidBinarySearchTree(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(min >= root.data || root.data >= max) return false;

        boolean left = isValidBSTUtil(root.left, min, root.data);
        boolean right = isValidBSTUtil(root.right, root.data, max);

        if(left && right) return true;
        return false;
    }
}
