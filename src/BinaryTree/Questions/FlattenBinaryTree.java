package BinaryTree.Questions;

import BinaryTree.TreeNode;

import java.util.Stack;

public class FlattenBinaryTree {

//    Using Recursion
    TreeNode prev = null;
    public void flattenBinaryTree(TreeNode root) {
        if(root == null) return;

        flattenBinaryTree(root.right);
        flattenBinaryTree(root.left);

        root.left = null;
        root.right = prev;
        prev = root;
    }

    // another method -- more TC than above
    public void flattenBinaryTree1(TreeNode root) {
        if(root == null) return;
        flattenBinaryTree1(root.left);
        flattenBinaryTree1(root.right);
        TreeNode leftMostRight = findLeftMostRight(root.left);
        if(root.left != null) {
            leftMostRight.right = root.right;
            root.right = root.left;
        }
        root.left = null;

    }
    private TreeNode findLeftMostRight(TreeNode node) {
        while(node != null && node.right != null) node = node.right;
        return node;
    }

//    Using Stack
    public void flattenBinaryTreeUsingStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return;
        if(root.right != null) stack.add(root.right);
        if(root.left != null) stack.add(root.left);
        TreeNode curr = root;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            curr.right = node;
            curr.left = null;
            curr = node;
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }
    }
}
