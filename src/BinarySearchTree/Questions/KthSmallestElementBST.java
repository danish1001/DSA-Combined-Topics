package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

import java.util.Stack;

public class KthSmallestElementBST {

    // using iterative way i.e using stack
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        addAll(root, stack);
        while(k != 1) {
            addAll(stack.pop().right, stack);
            k--;
        }
        return stack.peek().data;
    }
    public void addAll(TreeNode root, Stack<TreeNode> stack) {
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    // using recursion
    public int kthSmallestRecursion(TreeNode root, int k) {
        int[] res = {k, -1};
        solve(root, res);
        return res[1];
    }
    public void solve(TreeNode root, int[] res) {
        if(root == null) return;
        solve(root.left, res);
        res[0]--;
        if(res[0] == 0) res[1] = root.data;
        solve(root.right, res);
    }
}
