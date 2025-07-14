package Graph.Questions;

public class NumberOfEnclaves {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            if(grid[i][0] == 1 && !visited[i][0]) {
                dfs(grid, i, 0, n, m, visited);
            }
            if(grid[i][m-1] == 1 && !visited[i][m-1]) {
                dfs(grid, i, m-1, n, m, visited);
            }
        }

        for(int i=0; i<m; i++) {
            if(grid[0][i] == 1 && !visited[0][i]) {
                dfs(grid, 0, i, n, m, visited);
            }
            if(grid[n-1][i] == 1 && !visited[n-1][i]) {
                dfs(grid, n-1, i, n, m, visited);
            }
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        visited[i][j] = true;

        for(int ind=0; ind<4; ind++) {
            int row = dx[ind] + i;
            int col = dy[ind] + j;
            if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !visited[row][col]) {
                dfs(grid, row, col, n, m, visited);
            }
        }
    }
}
