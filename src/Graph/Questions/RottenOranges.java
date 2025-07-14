package Graph.Questions;

import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<pair> rotten = new LinkedList<>();
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int n = grid.length, m = grid[0].length;
        int oneCount = 0;
        boolean oneAvailable = false;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    oneCount++;
                    oneAvailable = true;
                }
                if(grid[i][j] == 2) {
                    visited[i][j] = true;;
                    rotten.add(new pair(i, j));
                }
            }
        }
        if(!oneAvailable) return 0;
        return solve(grid, n, m, rotten, dx, dy, oneCount, visited)-1;
    }
    public int solve(int[][] grid, int n, int m, Queue<pair> q, int[] dx, int[] dy, int oneCount, boolean[][] visited) {
        int count = 0;
        int ones = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            while(size != 0) {
                pair p = q.poll();

                for(int i=0; i<4; i++) {
                    int row = p.row + dx[i];
                    int col = p.col + dy[i];

                    if(row >=0 && col >=0 && row < n && col < m && grid[row][col] == 1 && !visited[row][col]) {
                        visited[row][col] = true;
                        q.add(new pair(row, col));
                        ones++;
                    }
                }
                size--;
            }
        }
        if(oneCount != ones) return 0;
        return count;
    }

    public class pair {
        int row;
        int col;
        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
