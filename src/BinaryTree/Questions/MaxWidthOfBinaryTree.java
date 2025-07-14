package BinaryTree.Questions;

import BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            int n = q.size();
            while(n != 0) {
                Pair p = q.pollFirst();
                if(p.node.left != null) q.addLast(new Pair(p.node.left, 2 * p.level + 1));
                if(p.node.right != null) q.addLast(new Pair(p.node.right, 2 * p.level + 2));
                n--;
            }
            if(!q.isEmpty()) res = Math.max(q.peekLast().level - q.peekFirst().level + 1, res);
        }
        return res;
    }

    public static class Pair {
        TreeNode node;
        int level;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
