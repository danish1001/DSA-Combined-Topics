package Graph.Questions.FindNumberOfIslands;

public class FindTheNumberOfIslandsDFS {
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
        if(i < 0 || j < 0 || i >= n || j >= m) return;

        if(!visited[i][j] && isValid(grid, i, j, n, m)) {
            visited[i][j] = true;
            traverse(grid, i-1, j, n, m, visited);
            traverse(grid, i-1, j+1, n, m, visited);
            traverse(grid, i, j+1, n, m, visited);
            traverse(grid, i+1, j+1, n, m, visited);
            traverse(grid, i+1, j, n, m, visited);
            traverse(grid, i+1, j-1, n, m, visited);
            traverse(grid, i, j-1, n, m, visited);
            traverse(grid, i-1, j-1, n, m, visited);
        }
    }

    public boolean isValid(char[][] grid, int i, int j, int n, int m) {
        if(grid[i][j] == '0') return false;
        if(i > 0 && grid[i-1][j] == '1') return true;
        if(i > 0 && j < m-1 && grid[i-1][j+1] == '1') return true;
        if(j < m-1 && grid[i][j+1] == '1') return true;
        if(i < n-1 && j < m-1 && grid[i+1][j+1] == '1') return true;
        if(i < n-1 && grid[i+1][j] == '1') return true;
        if(i < n-1 && j > 0 && grid[i+1][j-1] == '1') return true;
        if(j > 0 && grid[i][j-1] == '1') return true;
        if(i > 0 & j > 0 && grid[i-1][j-1] == '1') return true;
        return false;
    }
}
