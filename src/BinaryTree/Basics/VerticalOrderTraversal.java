package BinaryTree.Basics;
import BinaryTree.TreeNode;
import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();
        BFS(root, treeMap);
        addValues(res, treeMap);
        return res;
    }
    public void addValues(List<List<Integer>> res, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap) {
        for(TreeMap<Integer, PriorityQueue<Integer>> map: treeMap.values()) {
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq: map.values()) {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
    }
    public void BFS(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int row = 0;

        while(!q.isEmpty()) {
            int n = q.size();
            while(n != 0) {
                Pair p = q.poll();
                if(!treeMap.containsKey(p.col)) treeMap.put(p.col, new TreeMap<>());
                if(!treeMap.get(p.col).containsKey(row)) treeMap.get(p.col).put(row, new PriorityQueue<Integer>());

                treeMap.get(p.col).get(row).add(p.node.data);

                if(p.node.left != null) q.add(new Pair(p.node.left, p.col-1));
                if(p.node.right != null) q.add(new Pair(p.node.right, p.col+1));
                n--;
            }
            row++;
        }
    }
    public class Pair {
        TreeNode node;
        int col;
        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
