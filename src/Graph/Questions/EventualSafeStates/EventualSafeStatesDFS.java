package Graph.Questions.EventualSafeStates;

import java.util.*;

public class EventualSafeStatesDFS {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(dfs(adj, i, V, visited)) {
                    res.add(i);
                }
                visited[i] = false;
            }
        }
        return res;
    }

    public boolean dfs(List<List<Integer>> adj, int node, int V, boolean[] visited) {
        List<Integer> list = adj.get(node);
        for(int ele: list) {
            if(!visited[ele]) {
                visited[ele] = true;
                if(!dfs(adj, ele, V, visited)) {
                    visited[ele] = false;
                    return false;
                }
                visited[ele] = false;
            } else {
                return false;
            }
        }
        return true;
    }
}
