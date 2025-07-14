package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

import java.util.Stack;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator it1 = new BSTIterator(root, true);
        BSTIterator it2 = new BSTIterator(root, false);

        while(it1.peek() != it2.peek()) {
            int sum = it1.peek() + it2.peek();
            if(sum == k) {
                return true;
            } else if(sum > k) {
                it2.next();
            } else {
                it1.next();
            }
        }
        return false;
    }

    public static class BSTIterator {
        private final Stack<TreeNode> stack;
        private final boolean flag;

        public BSTIterator(TreeNode root, boolean flag) {
            this.stack = new Stack<>();
            this.flag = flag;
            addAll(root);
        }
        public void addAll(TreeNode root) {
            if(flag) {
                while(root != null) {
                    stack.add(root);
                    root = root.left;
                }
            } else {
                while(root != null) {
                    stack.add(root);
                    root = root.right;
                }
            }
        }
        public int peek() {
            return stack.peek().data;
        }
        public int next() {
            TreeNode node = stack.pop();
            if(flag) {
                addAll(node.right);
            } else {
                addAll(node.left);
            }
            return node.data;
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
