package RecursionBacktracking.Combos_HARD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueen {
    public List<List<String>> solveNQueens_sol1(int n) {
        List<List<String>> res = new ArrayList<>();
        // Use arrays to track columns and diagonals under attack
        boolean[] cols = new boolean[n];  // tracks column attacks
        boolean[] diag1 = new boolean[2 * n - 1];  // tracks left-to-right diagonal attacks
        boolean[] diag2 = new boolean[2 * n - 1];  // tracks right-to-left diagonal attacks
        List<Integer> temp = new ArrayList<>();

        solve(0, n, cols, diag1, diag2, temp, res);
        return res;
    }

    private void solve(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2,
                       List<Integer> temp, List<List<String>> res) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] rowStr = new char[n];
                Arrays.fill(rowStr, '.');
                rowStr[temp.get(i)] = 'Q'; // Place the queen in the right column
                board.add(new String(rowStr));
            }
            res.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            // Check if the column or diagonals are under attack
            if (cols[col] || diag1[row - col + n - 1] || diag2[row + col]) continue;

            // Place the queen and mark the column and diagonals as under attack
            temp.add(col);
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;

            // Recur for the next row
            solve(row + 1, n, cols, diag1, diag2, temp, res);

            // Backtrack: undo the changes
            temp.remove(temp.size() - 1);
            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }

    //-------------------------------------------------------------------------------------------
    public List<List<String>> solveNQueens_sol2(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String dots = "";
        for(int i=0; i<n; i++) dots += ".";
        for(int i=0; i<n; i++) list.add(dots);
        solveNQueensUtil(0, n, list, res);
        return res;
    }
    public void solveNQueensUtil(int row, int n, List<String> list, List<List<String>> res) {
        if(row >= n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int col=0; col<n; col++) {
            String str = list.get(row);
            String newStr = str.substring(0, col) + "Q" + str.substring(col+1);

            if(isPossible(list, row, col, n)) {
                list.set(row, newStr);
                solveNQueensUtil(row+1, n, list, res);
                list.set(row, str);
            }
        }
    }

    public boolean isPossible(List<String> res, int sr, int sc, int n) {
        int row = sr, col = sc;
        while(row >= 0 && col >= 0) {
            if(res.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }
        row = sr;
        col = sc;
        while(row >= 0) {
            if(res.get(row).charAt(col) == 'Q') return false;
            row--;
        }
        row = sr;
        col = sc;
        while(row >= 0 && col < n) {
            if(res.get(row).charAt(col) == 'Q') return false;
            row--;
            col++;
        }
        return true;
    }


}
