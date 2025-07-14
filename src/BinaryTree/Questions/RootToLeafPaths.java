package BinaryTree.Questions;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
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
