package Graph.Questions.TopologicalSort;

import java.util.*;

public class TopologicalSortBFS_KahnsAlgorithm {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for(int i=0; i<V; i++) {
            List<Integer> list = adj.get(i);
            for(int ele: list) inDegree[ele]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[V];
        int index = 0;
        for(int i=0; i<V; i++)
            if(inDegree[i] == 0) {
                q.add(i);
            }

        while(!q.isEmpty()) {
            int e = q.poll();
            res[index++] = e;

            List<Integer> list = adj.get(e);
            for(int ele: list) {
                inDegree[ele]--;
                if(inDegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        return res;
    }
}
