package Array.Medium;

import java.util.ArrayList;
import java.util.List;

// Given an m x n matrix, return all elements of the matrix in spiral order.
// Direction Clockwise
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int rowStart = 0, rowEnd = n-1;
        int colStart = 0, colEnd = m-1;
        int row, col;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            row = rowStart;
            col = colStart;
            while(col <= colEnd) {
                res.add(matrix[row][col]);
                col++;
            }
            rowStart++;
            if(rowStart > rowEnd) break;
            row = rowStart;
            col = colEnd;
            while(row <= rowEnd) {
                res.add(matrix[row][col]);
                row++;
            }
            colEnd--;
            if(colStart > colEnd) break;
            row = rowEnd;
            col = colEnd;
            while(col >= colStart) {
                res.add(matrix[row][col]);
                col--;
            }
            rowEnd--;
            if(rowStart > rowEnd) break;
            row = rowEnd;
            col = colStart;
            while(row >= rowStart) {
                res.add(matrix[row][col]);
                row--;
            }
            colStart++;
        }
        return res;
    }
}
