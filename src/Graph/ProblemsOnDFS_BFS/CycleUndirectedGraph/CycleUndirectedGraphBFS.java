package Graph.ProblemsOnDFS_BFS.CycleUndirectedGraph;

import java.util.*;

public class CycleUndirectedGraphBFS {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                if(hasCycle(V, adj, i, visited)) return true;
            }
        }
        return false;
    }

    public boolean hasCycle(int V, List<List<Integer>> adj, int start, boolean[] visited) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(start, -1));
        visited[start] = true;
        while(!q.isEmpty()) {
            pair p = q.poll();

            List<Integer> list = adj.get(p.child);

            for(int i=0; i<list.size(); i++) {
                int index = (int) list.get(i);
                if(!visited[index]) {
                    q.add(new pair(index, p.child));
                    visited[index] = true;
                } else {
                    if(index != p.parent) return true;
                }
            }
        }
        return false;
    }

    public class pair {
        int child;
        int parent;
        public pair(int c, int p) {
            this.child = c;
            this.parent = p;
        }
    }
}
