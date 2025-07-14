package Graph.Questions;

public class ReplaceOWithX {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] fill(int n, int m, char a[][]) {
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            if(a[i][0] == 'O' && !visited[i][0]) {
                dfs(a, i, 0, n, m, visited);
            }
            if(a[i][m-1] == 'O' && !visited[i][m-1]) {
                dfs(a, i, m-1, n, m, visited);
            }
        }
        for(int i=0; i<m; i++) {
            if(a[0][i] == 'O' && !visited[0][i]) {
                dfs(a, 0, i, n, m, visited);
            }
            if(a[n-1][i] == 'O' && !visited[n-1][i]) {
                dfs(a, n-1, i, n, m, visited);
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a[i][j] != 'X' && !visited[i][j]) a[i][j] = 'X';
            }
        }

        return a;
    }

    public static void dfs(char[][] a, int i, int j, int n, int m, boolean[][] visited) {
        if(visited[i][j]) return;
        visited[i][j] = true;

        for(int k=0; k<4; k++) {
            int row = dx[k] + i;
            int col = dy[k] + j;

            if(row >= 0 && row < n && col >= 0 && col < m && !visited[row][col] && a[row][col] == 'O') {
                visited[i][j] = true;
                dfs(a, row, col, n, m, visited);
            }
        }
    }
}
