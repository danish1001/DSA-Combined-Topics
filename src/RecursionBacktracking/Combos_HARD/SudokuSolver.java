package RecursionBacktracking.Combos_HARD;

public class SudokuSolver {
    // most optimized solution
    public void solveSudoku(char[][] board) {
        // Use int arrays to track the numbers used in rows, columns, and 3x3 subgrids
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // Initialize the board by marking already filled numbers
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1'; // map '1' -> 0, '9' -> 8
                    rows[r] |= (1 << num); // Mark this number as used in this row
                    cols[c] |= (1 << num); // Mark this number as used in this column
                    boxes[(r / 3) * 3 + c / 3] |= (1 << num); // Mark this number as used in this box
                }
            }
        }

        solve(board, rows, cols, boxes, 0, 0);
    }

    private boolean solve(char[][] board, int[] rows, int[] cols, int[] boxes, int row, int col) {
        // If we've filled all rows, return true (solved)
        if (row == 9) return true;
        if (col == 9) return solve(board, rows, cols, boxes, row + 1, 0); // Move to the next row

        if (board[row][col] != '.') return solve(board, rows, cols, boxes, row, col + 1); // Skip filled cells

        // Try digits from '1' to '9'
        for (int num = 0; num < 9; num++) {
            int boxIndex = (row / 3) * 3 + col / 3;

            // Check if the current number is valid for this position
            if ((rows[row] & (1 << num)) == 0 && (cols[col] & (1 << num)) == 0 && (boxes[boxIndex] & (1 << num)) == 0) {
                // Make the move
                board[row][col] = (char) (num + '1');
                rows[row] |= (1 << num); // Mark the number as used in this row
                cols[col] |= (1 << num); // Mark the number as used in this column
                boxes[boxIndex] |= (1 << num); // Mark the number as used in this box

                // Recursively try to solve the next cell
                if (solve(board, rows, cols, boxes, row, col + 1)) return true;

                // Undo the move (backtrack)
                board[row][col] = '.';
                rows[row] &= ~(1 << num); // Unmark the number from this row
                cols[col] &= ~(1 << num); // Unmark the number from this column
                boxes[boxIndex] &= ~(1 << num); // Unmark the number from this box
            }
        }

        return false; // No valid number found, trigger backtracking
    }

    // ----------------------------------------------------------------------------------------------

    public boolean solveSudoku_sol1(char[][] board) {

        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {

                if(board[row][col] == '.') {
                    for(char num='1'; num<='9'; num++) {

                        if(isValid(board, row, col, num)) {
                            board[row][col] = num;
                            boolean response = solveSudoku_sol1(board);
                            if(response) return true;
                            board[row][col] = '.';
                        }

                    }
                    return false;
                }

            }
        }
        return true;
    }
    // Another Method --------------------------------------
    public void solveSudoku_sol2(char[][] board) {
        solve(board, 0, 0);
    }
    private boolean solve(char[][] board, int row, int col) {
        if(row == 9) return true;
        if(col == 9) return solve(board, row+1, 0);
        if(board[row][col] != '.') return solve(board, row, col+1);

        for(char num='1'; num<='9'; num++) {
            if(isValid(board, row, col, num)) {
                board[row][col] = num;
                if(solve(board, row, col+1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    // common method
    public boolean isValid(char[][] board, int row, int col, char num) {
        for(int i=0; i<9; i++) {
            if(board[row][i] == num) return false;
            if(board[i][col] == num) return false;
        }
        row = (row/3) * 3;
        col = (col/3) * 3;
        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

}
