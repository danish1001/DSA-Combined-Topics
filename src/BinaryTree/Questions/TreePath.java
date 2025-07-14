package BinaryTree.Questions;

import BinaryTree.TreeNode;
import java.util.*;

public class TreePath {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSumUtil(root, max);
        return max[0];
    }

    public int maxPathSumUtil(TreeNode root, int[] max) {
        if(root == null) return Integer.MIN_VALUE;

        int left = maxPathSumUtil(root.left, max);
        int right = maxPathSumUtil(root.right, max);

        if(left < 0) left = 0;
        if(right < 0) right = 0;
        int sum = root.data + left + right;

        max[0] = Math.max(sum, max[0]);
        return root.data + Math.max(left, right);
    }


    public static List<List<Integer>> Paths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        pathsUtil(root, res, new ArrayList<>());
        return res;
    }

    public static void pathsUtil(TreeNode root, List<List<Integer>> res, List<Integer> list) {
        if(root == null) return;
        if(isLeaf(root)) {
            list.add(root.data);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.data);
        pathsUtil(root.left, res, list);
        pathsUtil(root.right, res, list);
        list.remove(list.size()-1);
    }
    public static boolean isLeaf(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return false;
    }
}
