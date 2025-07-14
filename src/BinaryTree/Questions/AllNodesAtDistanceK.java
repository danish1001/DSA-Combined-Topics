package BinaryTree.Questions;

import BinaryTree.TreeNode;

import java.util.*;

public class AllNodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        addParentChildMapping(root, parentChildMap);
        distanceKUtil(target, k, res, visited, parentChildMap);
        return res;
    }
    public void distanceKUtil(TreeNode root, int k, List<Integer> res, Set<TreeNode> visited, Map<TreeNode, TreeNode> parentChildMap) {
        if(root == null || visited.contains(root)) return;
        if(k == 0) {
            res.add(root.data);
            return;
        }
        visited.add(root);
        distanceKUtil(parentChildMap.get(root), k-1, res, visited, parentChildMap);
        distanceKUtil(root.left, k-1, res, visited, parentChildMap);
        distanceKUtil(root.right, k-1, res, visited, parentChildMap);
        visited.remove(root);
    }
    public void addParentChildMapping(TreeNode root, Map<TreeNode, TreeNode> parentChildMap) {
        if(root.left != null) {
            parentChildMap.put(root.left, root);
            addParentChildMapping(root.left, parentChildMap);
        }
        if(root.right != null) {
            parentChildMap.put(root.right, root);
            addParentChildMapping(root.right, parentChildMap);
        }
    }
}
