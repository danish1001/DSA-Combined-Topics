package Graph;

import java.util.Arrays;
import java.util.List;

public class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;
    public DisjointSet(int n) {
        this.parent = new int[n+1];
        this.rank = new int[n+1];
        this.size = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }
    public int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        int nodeParent = findParent(parent[node]);
        return parent[node] = nodeParent;
    }
    public void unionBySize(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if(uParent == vParent) return;
        if(size[uParent] < size[vParent]) {
            parent[uParent] = vParent;
            size[vParent] = size[vParent] + size[uParent];
        } else {
            parent[vParent] = uParent;
            size[uParent] = size[uParent] + size[vParent];
        }
    }
    // i.e. this insert edge into Graph
    public void unionByRank(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        int uParentRank = rank[uParent];
        int vParentRank = rank[vParent];

        if(uParentRank < vParentRank) {
            parent[uParent] = vParent;
        } else if(uParentRank > vParentRank) {
            parent[vParent] = uParent;
        } else {
            // here uParent is the parent of vParent hence increasing rank of uParent
            parent[vParent] = uParent;
            rank[uParent] = rank[uParent] + 1;
        }
    }

}
