package BinarySearchTree.Questions;

import BinaryTree.TreeNode;

public class LargestBSTinBT {
    public int largestBst(TreeNode root) {
        return solve(root).size;
    }

    public static Tuple solve(TreeNode root) {
        if(root == null) return new Tuple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Tuple left = solve(root.left);
        Tuple right = solve(root.right);
        if(left.max >= root.data || right.min <= root.data) {
            return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        }
        return new Tuple(Math.min(root.data, left.min), Math.max(root.data, right.max), 1 + left.size + right.size);
    }
    public static class Tuple {
        int min, max, size;
        public Tuple(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
}
