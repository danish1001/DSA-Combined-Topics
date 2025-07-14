package BinarySearch.BinarySearchOn2DArrays;
//1901. Find a Peak Element II https://leetcode.com/problems/find-a-peak-element-ii/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
//
//        Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
//
//        You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
//
//        You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
//
//
//
//        Example 1:
//
//
//
//        Input: mat = [[1,4],[3,2]]
//        Output: [0,1]
//        Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
//        Example 2:
//
//
//
//        Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
//        Output: [1,1]
//        Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
//
//
//        Constraints:
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n <= 500
//        1 <= mat[i][j] <= 105
//        No two adjacent cells are equal.
public class PeakElementIn2DMatrix {
    public int[] findPeakGrid_sol1(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = n-1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int peakIndCol = findPeakElement(mat[mid], m);

            int up = -1;
            int down = -1;
            if(mid > 0) up = mat[mid-1][peakIndCol];
            if(mid < n-1) down = mat[mid+1][peakIndCol];

            if(up < mat[mid][peakIndCol] && mat[mid][peakIndCol] > down) {
                return new int[]{mid, peakIndCol};
            } else if(up > mat[mid][peakIndCol]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[2];
    }
    private int findPeakElement(int[] arr, int n) {
        int max = 0;
        for(int i=0; i<n; i++) {
            if(arr[max] < arr[i]) max = i;
        }
        return max;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int[] findPeakGrid_sol2(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int row = 0, col = 0;

        while(row >= 0 && row < n && col >= 0 && col < m) {
            int up = -1, left = -1, right = -1, down = -1;
            int element = mat[row][col];

            if(row > 0) up = mat[row-1][col];
            if(row < n-1) down = mat[row+1][col];
            if(col > 0) left = mat[row][col-1];
            if(col < m-1) right = mat[row][col+1];

            if(up < element && element > down && left < element && element > right) {
                return new int[]{row, col};
            } else if(down > element) {
                row++;
            } else if(up > element) {
                row--;
            } else if(left > element) {
                col--;
            } else {
                col++;
            }
        }
        return new int[2];
    }
}
