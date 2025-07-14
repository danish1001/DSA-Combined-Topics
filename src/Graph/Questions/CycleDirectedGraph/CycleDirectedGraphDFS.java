package Graph.Questions.CycleDirectedGraph;

import java.util.*;

public class CycleDirectedGraphDFS {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] currPath = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                visited[i] = true;
                currPath[i] = true;
                if(isCyclic(adj, i, V, visited, currPath)) return true;
                currPath[i] = false;
            }
        }
        return false;
    }
    public boolean isCyclic(List<List<Integer>> adj, int node, int V, boolean[] visited, boolean[] currPath) {
        List<Integer> list = adj.get(node);
        for(int index: list) {
            if(!visited[index]) {
                visited[index] = true;
                currPath[index] = true;
                if(isCyclic(adj, index, V, visited, currPath)) return true;
                currPath[index] = false;
            } else if(currPath[index]) {
                return true;
            }
        }
        return false;
    }
}
