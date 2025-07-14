package Graph.Questions.BipartiteGraph;

import java.util.*;

public class BipartiteGraphDFS {
    public boolean isBipartite(int V, List<List<Integer>>adj) {
        int[] visitedColor = new int[V];

        for(int i=0; i<V; i++) {
            if(visitedColor[i] == 0) {
                visitedColor[i] = 1;
                boolean res = dfs(adj, V, i, -1, 1, visitedColor);
                if(!res) return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>>adj, int V, int currNode, int parent, int color, int[] visitedColor) {
        if(color == 1) color = 2;
        else color = 1;

        visitedColor[currNode] = color;
        List<Integer> list = adj.get(currNode);

        for(int i=0; i<list.size(); i++) {
            int index = list.get(i);
            if(visitedColor[index] == 0) {
                if(!dfs(adj, V, index, currNode, color, visitedColor)) return false;
            } else {
                if(parent != currNode && visitedColor[index] == color) return false;
            }
        }
        return true;
    }
}
