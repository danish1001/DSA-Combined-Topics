package Graph.Questions.TopologicalSort;

import java.util.*;

public class TopologicalSortDFS {
    public List<Integer> topologicalSort(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) res.add(stack.pop());
        return res;
    }

    public static void dfs(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> stack) {
        List<Integer> list = adj.get(node);
        visited[node] = true;
        for(int ele: list) {
            if(!visited[ele]) {
                dfs(adj, ele, visited, stack);
            }
        }
        stack.add(node);
    }
}
