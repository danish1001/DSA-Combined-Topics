package BinaryTree.Basics;

import BinaryTree.TreeNode;

import java.util.*;

public class BinaryTreeViews {

    // Top View
    public List<Integer> topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(!map.containsKey(p.col)) map.put(p.col, p.node.data);
            if(p.node.left != null) q.add(new Pair(p.node.left, p.col - 1));
            if(p.node.right != null) q.add(new Pair(p.node.right, p.col + 1));
        }
        return new ArrayList<>(map.values());
    }

    // Bottom View
    public List<Integer> bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            map.put(p.col, p.node.data);
            if(p.node.left != null) q.add(new Pair(p.node.left, p.col - 1));
            if(p.node.right != null) q.add(new Pair(p.node.right, p.col + 1));
        }
        return new ArrayList<>(map.values());
    }

    // Left/Right View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewUtil(root, res, 0);
        return res;
    }
    public void rightSideViewUtil(TreeNode root, List<Integer> res, int depth) {
        if(root == null) return;
        if(res.size() == depth) res.add(root.data);
        rightSideViewUtil(root.right, res, depth + 1);
        rightSideViewUtil(root.left, res, depth + 1);
    }
    public static class Pair {
        TreeNode node;
        int col;
        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
