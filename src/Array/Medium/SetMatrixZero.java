package Array.Medium;

import java.util.HashSet;
import java.util.Set;

//73. Set Matrix Zeroes https://leetcode.com/problems/set-matrix-zeroes/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//        You must do it in place.
//
//
//
//        Example 1:
//
//
//        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        Output: [[1,0,1],[0,0,0],[1,0,1]]
//        Example 2:
//
//
//        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
public class SetMatrixZero {
    public void setZeroes_sol1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rowZero = false, colZero = false;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0) {
                    if(matrix[i][j] == 0) rowZero = true;
                } else if(j == 0) {
                    if(matrix[i][j] == 0) colZero = true;
                } else if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<n; i++) {
            if(matrix[i][0] == 0) {
                for(int j=0; j<m; j++) matrix[i][j] = 0;
            }
        }
        for(int j=1; j<m; j++) {
            if(matrix[0][j] == 0) {
                for(int i=0; i<n; i++) matrix[i][j] = 0;
            }
        }
        if(matrix[0][0] == 0 || (rowZero && colZero)) {
            for(int i=0; i<n; i++) matrix[i][0] = 0;
            for(int j=0; j<m; j++) matrix[0][j] = 0;
        } else if(rowZero) {
            for(int j=0; j<m; j++) matrix[0][j] = 0;
        } else if(colZero) {
            for(int i=0; i<n; i++) matrix[i][0] = 0;
        }
    }

    //-------------------------------------------------------------
    public void setZeroes_sol2(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int n = matrix.length, m = matrix[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int row: rowSet) {
            for(int j=0; j<m; j++) matrix[row][j] = 0;
        }

        for(int col: colSet) {
            for(int i=0; i<n; i++) matrix[i][col] = 0;
        }
    }

    //-------------------------------------------------------------

    public void setZeroes_sol3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = matrix[i][j];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    rowZero(arr, i, m);
                    colZero(arr, j, n);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
    public void rowZero(int[][] arr, int row, int colLen) {
        for(int i=0; i<colLen; i++) {
            arr[row][i] = 0;
        }
    }
    public void colZero(int[][] arr, int col, int rowLen) {
        for(int i=0; i<rowLen; i++) {
            arr[i][col] = 0;
        }
    }
}
