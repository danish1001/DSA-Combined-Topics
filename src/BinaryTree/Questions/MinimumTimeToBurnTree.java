package BinaryTree.Questions;

import BinaryTree.TreeNode;
import java.util.*;

public class MinimumTimeToBurnTree {
//    Given a binary tree and a node data called target.
//    Find the minimum time required to burn the complete binary tree if the target is set on fire.
//    It is known that in 1 second all nodes connected to a given node get burned.
//    That is its left child, right child, and parent.
//    Note: The tree contains unique values.
    public static int minTime(TreeNode root, int target) {
        int[] res = new int[1];
        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
        addParentChildMapping(root, parentChildMap);
        TreeNode targetNode = findTargetNode(root, target);
        findMinTime(targetNode, parentChildMap, new HashSet<TreeNode>(), 0, res);
        return res[0];
    }
    public static void findMinTime(TreeNode root, Map<TreeNode, TreeNode> parentChildMap, Set<TreeNode> visited, int time, int[] res) {
        if(root == null || visited.contains(root)) return;
        res[0] = Math.max(time, res[0]);
        visited.add(root);
        findMinTime(parentChildMap.get(root), parentChildMap, visited, time + 1, res);
        findMinTime(root.left, parentChildMap, visited, time + 1, res);
        findMinTime(root.right, parentChildMap, visited, time + 1, res);
        visited.remove(root);
    }
    public static void addParentChildMapping(TreeNode root, Map<TreeNode, TreeNode> parentChildMap) {
        if(root.left != null) {
            parentChildMap.put(root.left, root);
            addParentChildMapping(root.left, parentChildMap);
        }
        if(root.right != null) {
            parentChildMap.put(root.right, root);
            addParentChildMapping(root.right, parentChildMap);
        }
    }
    public static TreeNode findTargetNode(TreeNode root, int target) {
        if(root.data == target) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.data == target) return node;
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return null;
    }
}
