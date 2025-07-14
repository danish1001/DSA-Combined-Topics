package BinarySearch.BinarySearchOn2DArrays;

//240. Search a 2D Matrix II https://leetcode.com/problems/search-a-2d-matrix-ii/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//
//
//        Example 1:
//
//
//        Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//        Output: true
//        Example 2:
//
//
//        Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//        Output: false
//
//
//        Constraints:
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= n, m <= 300
//        -109 <= matrix[i][j] <= 109
//        All the integers in each row are sorted in ascending order.
//        All the integers in each column are sorted in ascending order.
//        -109 <= target <= 109
public class SearchInARowColumnSortedMatrix {
    public boolean searchMatrix_sol1(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;
        while(row < n && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    //------------------------------------------------------------------
    public boolean searchMatrix_sol2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        for(int i=0; i<n; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][m-1]) {
                if(search(matrix[i], 0, m-1, target)) return true;
            }
        }
        return false;
    }
    private boolean search(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
