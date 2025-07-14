package Graph.ProblemsOnDFS_BFS.CycleUndirectedGraph;

import java.util.*;

public class CycleUndirectedGraphDFS {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(hasCycle(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }

    public boolean hasCycle(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        List<Integer> list = adj.get(node);

        for(int i=0; i<list.size(); i++) {
            int ele = list.get(i);
            if(!visited[ele]) {
                visited[ele] = true;
                if(hasCycle(ele, node, adj, visited)) return true;
            } else if(ele != parent) {
                return true;
            }
        }
        return false;
    }
}
