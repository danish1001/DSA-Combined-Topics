package BinaryTree.Questions;

import BinaryTree.TreeNode;

public class CountCompleteTreeNodes {
//    Given the root of a complete binary tree, return the number of the nodes in the tree.
//    According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
//    and all nodes in the last level are as far left as possible.
//    It can have between 1 and 2h nodes inclusive at the last level h.
//    Design an algorithm that runs in less than O(n) time complexity.
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftH = leftHeight(root);
        int rightH = rightHeight(root);
        if(leftH == rightH) {
            return (int) Math.pow(2, leftH) - 1;
        } else {
            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return 1 + left + right;
        }
    }
    public int leftHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + leftHeight(root.left);
    }
    public int rightHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + rightHeight(root.right);
    }
}
