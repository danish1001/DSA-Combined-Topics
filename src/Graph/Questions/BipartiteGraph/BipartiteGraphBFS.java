package Graph.Questions.BipartiteGraph;

import java.util.*;

public class BipartiteGraphBFS {
    public boolean isBipartite(int V, List<List<Integer>>adj) {
        int[] color = new int[V];

        for(int i=0; i<V; i++) {
            if(color[i] == 0) {
                color[i] = 1;
                if(!bfs(adj, V, i, color)) return false;
            }
        }
        return true;
    }

    public boolean bfs(List<List<Integer>>adj, int V, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            int index = q.poll();
            int currColor = color[index];
            List<Integer> list = adj.get(index);
            for(int ele: list) {
                if(color[ele] == 0) {
                    if(currColor == 1) color[ele] = 2;
                    else color[ele] = 1;
                    q.add(ele);
                } else {
                    if(color[ele] == currColor) return false;
                }
            }
        }
        return true;
    }
}
