package Graph.Questions;

import java.util.*;

public class DistanceNearestCellHaving1 {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        bfs(grid, q, n, m, res, visited);
        return res;
    }

    public void bfs(int[][] grid, Queue<Tuple> q, int n, int m, int[][] res, boolean[][] visited) {
        while(!q.isEmpty()) {
            Tuple p = q.poll();
            res[p.row][p.col] = p.count;

            for(int k=0; k<4; k++) {
                int myRow = p.row + dx[k];
                int myCol = p.col + dy[k];

                if(myRow >=0 && myRow < n && myCol >= 0 && myCol < m && !visited[myRow][myCol]) {
                    q.add(new Tuple(myRow, myCol, p.count + 1));
                    visited[myRow][myCol] = true;
                }
            }
        }
    }

    public class Tuple {
        int count;
        int row;
        int col;
        public Tuple(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
