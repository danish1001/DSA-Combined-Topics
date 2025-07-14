package BinaryTree.Questions;

import BinaryTree.TreeNode;

public class ChildrenSumProperty {
//    Given a binary tree having n nodes.
//    Check whether all of its nodes have a value equal to the sum of their child nodes.
//    Return 1 if all the nodes in the tree satisfy the given properties, else it returns 0.
//    For every node, the data value must be equal to the sum of the data values in the left and right children.
//    Consider the data value 0 for a NULL child. Also, leaves are considered to follow the property.
    public static int isSumProperty(TreeNode root) {
        if(isSumPropertyUtil(root) == -1) return 0;
        return 1;
    }
    public static int isSumPropertyUtil(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        int left = isSumPropertyUtil(root.left);
        int right = isSumPropertyUtil(root.right);

        if(left == -1 || right == -1 || root.data != left + right) return -1;
        return root.data;
    }
}
