package BinaryTree.Questions;

import BinaryTree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root, root);
    }
    public boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.data != root2.data) return false;

        boolean left = isSymmetricUtil(root1.left, root2.right);
        boolean right = isSymmetricUtil(root1.right, root2.left);
        if(left && right) return true;
        return false;
    }
}
