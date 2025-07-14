package Graph.Basics;

import java.util.*;

public class BFS {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int ele = q.poll();
            res.add(ele);
            List<Integer> list = adj.get(ele);
            for(int i=0; i<list.size(); i++) {
                if(!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    q.add(list.get(i));
                }
            }
        }

        return res;
    }
}
