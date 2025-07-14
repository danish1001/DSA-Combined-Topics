package Graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MST_MinimumSpanningTree {
    public int minimumSpanningTree_PrimsAlgorithm(int V, int E, List<List<int[]>> adj) { // int[] has {u, v, wt}
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.wt - p2.wt;
            }
        });
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int cost = 0;

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();

            if(visited[pair.node]) continue;
            visited[pair.node] = true;
            cost += pair.wt;

            List<int[]> list = adj.get(pair.node);
            for(int[] edge: list) {
                pq.add(new Pair(edge[0], edge[1]));
            }
        }
        return cost;
    }
    public class Pair {
        int node, wt;
        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
}
