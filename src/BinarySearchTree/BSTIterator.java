package BinarySearchTree;

import BinaryTree.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAll(root);
    }

    public int next() {
        if(!hasNext()) return -1;
        TreeNode node = stack.pop();
        addAll(node.right);
        return node.data;
    }

    public void addAll(TreeNode root) {
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
