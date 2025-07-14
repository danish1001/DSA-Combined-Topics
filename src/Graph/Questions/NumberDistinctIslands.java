package Graph.Questions;

import java.util.*;

public class NumberDistinctIslands {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    List<String> list = new ArrayList<>();
                    dfs(grid, i, j, n, m, visited, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, int n, int m, boolean[][] visited, List<String> list,
                    int startRowInd, int startColInd) {

        visited[i][j] = true;
        list.add("(" + (i-startRowInd) + "," + (j-startColInd) + ")");

        for(int ind=0; ind<4; ind++) {
            int row = dx[ind] + i;
            int col = dy[ind] + j;
            if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !visited[row][col]) {
                dfs(grid, row, col, n, m, visited, list, startRowInd, startColInd);
            }
        }
    }
}
