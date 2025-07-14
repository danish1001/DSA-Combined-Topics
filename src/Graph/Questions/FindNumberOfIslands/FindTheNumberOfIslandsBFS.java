package Graph.Questions.FindNumberOfIslands;

import java.util.*;

public class FindTheNumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    traverse(grid, i, j, row, col, visited);
                }
            }
        }


        return res;
    }

    public void traverse(char[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        visited[i][j] = true;
        while(!q.isEmpty()) {
            pair p = q.poll();

            for(int row = -1; row < 2; row++) {
                for(int col = -1; col < 2; col++) {
                    int myRow = p.row + row;
                    int myCol = p.col + col;
                    if(myRow >= 0 && myRow < n && myCol>=0 && myCol < m && grid[myRow][myCol] == '1') {
                        if(!visited[myRow][myCol]) {
                            visited[myRow][myCol] = true;
                            q.add(new pair(myRow, myCol));
                        }
                    }
                }
            }

        }
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
