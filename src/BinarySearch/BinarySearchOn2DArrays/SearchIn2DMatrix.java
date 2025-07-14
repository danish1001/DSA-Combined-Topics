package BinarySearch.BinarySearchOn2DArrays;
//74. Search a 2D Matrix https://leetcode.com/problems/search-a-2d-matrix/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        You are given an m x n integer matrix matrix with the following two properties:
//
//        Each row is sorted in non-decreasing order.
//        The first integer of each row is greater than the last integer of the previous row.
//        Given an integer target, return true if target is in matrix or false otherwise.
//
//        You must write a solution in O(log(m * n)) time complexity.
//
//
//
//        Example 1:
//
//
//        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        Output: true
//        Example 2:
//
//
//        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//        Output: false
//
//
//        Constraints:
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 100
//        -104 <= matrix[i][j], target <= 104
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while(row < n && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
