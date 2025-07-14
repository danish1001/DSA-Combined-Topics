package Graph.Questions.EventualSafeStates;

import java.util.*;

public class EventualSafeStatesBFS_Topo_Sort {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> reversedAdj = getReversedAdj(adj, V);
        return topoSort(reversedAdj, V);
    }

    public List<List<Integer>> getReversedAdj(List<List<Integer>> adj, int V) {
        List<List<Integer>> reversedAdj = new ArrayList<>();
        for(int i=0; i<adj.size(); i++) reversedAdj.add(new ArrayList<>());

        for(int from=0; from<adj.size(); from++) {
            for(int to: adj.get(from)) {
                reversedAdj.get(to).add(from);
            }
        }
        return reversedAdj;
    }

    public List<Integer> topoSort(List<List<Integer>> adj, int V) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for(int i=0; i<adj.size(); i++) {
            for(int ele: adj.get(i)) {
                indegree[ele]++;
            }
        }
        for(int i=0; i<V; i++) if(indegree[i] == 0) q.add(i);

        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            List<Integer> list = adj.get(node);
            for(int ele: list) {
                indegree[ele]--;
                if(indegree[ele] == 0) q.add(ele);
            }
        }
        Collections.sort(res);
        return res;
    }
}
