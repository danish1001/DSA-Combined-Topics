package Graph.Questions;

import java.util.*;

public class NumberOfProvinces {
    static int numProvinces(List<List<Integer>> adj, int V) {
        List<List<Integer>> adjList = convert(adj);
        int res = 0;
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                res++;
                dfs(adjList, i, visited);
            }
        }
        return res;
    }

    private static void dfs(List<List<Integer>> adj, int i, boolean[] visited) {
        visited[i] = true;
        List<Integer> list = adj.get(i);
        for(int ind = 0; ind < list.size(); ind++) {
            if(!visited[list.get(ind)]) dfs(adj, list.get(ind), visited);
        }
    }

    private static List<List<Integer>> convert(List<List<Integer>> mat) {
        int row = mat.size();
        int col = mat.get(0).size();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<row; i++) res.add(new ArrayList<>());

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat.get(i).get(j) == 1 && i != j) {
                    res.get(i).add(j);
                    res.get(j).add(i);
                }
            }
        }
        return res;
    }
}
