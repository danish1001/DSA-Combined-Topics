package RecursionBacktracking.Combos_HARD;
//79. Word Search https://leetcode.com/problems/word-search/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
//        Example 1:
//
//
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        Output: true
//        Example 2:
//
//
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//        Output: true
//        Example 3:
//
//
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//        Output: false
//
//
//        Constraints:
//
//        m == board.length
//        n = board[i].length
//        1 <= m, n <= 6
//        1 <= word.length <= 15
//        board and word consists of only lowercase and uppercase English letters.
//
//
//        Follow up: Could you use search pruning to make your solution faster with a larger board?
public class WordSearch {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public boolean exist_sol1(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        int wordLength = word.length();
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = true;
                if(search(board, i, j, n, m, word, 0, wordLength, visited)) return true;
                visited[i][j] = false;
            }
        }
        return false;
    }
    private boolean search(char[][] board, int i, int j, int n, int m, String word, int wi, int wn, boolean[][] visited) {
        if(wi == wn-1 && board[i][j] == word.charAt(wi)) return true;
        if(word.charAt(wi) != board[i][j]) return false;

        for(int k=0; k<4; k++) {
            int row = i + dx[k];
            int col = j + dy[k];
            if(row >= 0 && row < n && col >= 0 && col < m) {
                if(visited[row][col]) continue;

                visited[row][col] = true;
                if(search(board, row, col, n, m, word, wi+1, wn, visited)) return true;
                visited[row][col] = false;
            }
        }
        return false;
    }
    // ----------------------------------------------------------------------------
    public boolean exist_sol2(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(search(board, i, j, n, m, word, 0, new boolean[n][m])) return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, int n, int m, String word, int index, boolean[][] visited) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i == n || j == m || visited[i][j]) return false;
        if(board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            boolean left = search(board, i, j-1, n, m, word, index+1, visited);
            boolean right = search(board, i, j+1, n, m, word, index+1, visited);
            boolean up = search(board, i-1, j, n, m, word, index+1, visited);
            boolean down = search(board, i+1, j, n, m, word, index+1, visited);
            visited[i][j] = false;
            if(left || right || up || down) return true;
        }
        return false;
    }
}
