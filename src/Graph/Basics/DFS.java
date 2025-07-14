package Graph.Basics;

import java.util.*;

public class DFS {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] b = new boolean[V];
        dfs(0, adj, b, res);
        return res;
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> res) {
        visited[node] = true;
        res.add(node);

        List<Integer> list = adj.get(node);

        for(int i=0; i<list.size(); i++) {
            if(!visited[list.get(i)]) {
                dfs(list.get(i), adj, visited, res);
            }
        }
    }
}
