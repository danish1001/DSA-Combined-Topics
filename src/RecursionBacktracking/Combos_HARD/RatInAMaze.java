package RecursionBacktracking.Combos_HARD;

import java.util.ArrayList;
import java.util.Collections;

//Rat in a Maze Problem - I https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//        Difficulty: MediumAccuracy: 35.75%Submissions: 332K+Points: 4Average Time: 25m
//        Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).
//
//        The matrix contains only two possible values:
//
//        0: A blocked cell through which the rat cannot travel.
//        1: A free cell that the rat can pass through.
//        Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
//        If no path exists, return an empty list.
//
//        Note: Return the final result vector in lexicographically smallest order.
//
//        Examples:
//
//        Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
//        Output: ["DDRDRR", "DRDDRR"]
//        Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
//        Input: mat[][] = [[1, 0], [1, 0]]
//        Output: []
//        Explanation: No path exists as the destination cell is blocked.
//        Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
//        Output: ["DDRR", "RRDD"]
//        Explanation: The rat has two possible paths to reach the destination: 1. "DDRR" 2. "RRDD", These are returned in lexicographically sorted order.
//        Constraints:
//        2 ≤ mat.size() ≤ 5
//        0 ≤ mat[i][j] ≤ 1
//
//        Expected Complexities
//        Time Complexity: O(4 ^ (n * n))
//        Auxiliary Space: O(n * n)
public class RatInAMaze {
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> res = new ArrayList<>();
        int n = mat.size();
        solve(mat, 0, 0, n, res, "", new boolean[n][n]);
        Collections.sort(res);
        return res;
    }
    private void solve(ArrayList<ArrayList<Integer>> mat, int i, int j, int n, ArrayList<String> res, String out, boolean[][] visited) {
        if(i < 0 || i == n || j < 0 || j == n) return;
        if(mat.get(i).get(j) == 0 || visited[i][j]) return;

        if(i == n-1 && j == n-1) {
            res.add(out);
            return;
        }

        visited[i][j] = true;
        solve(mat, i-1, j, n, res, out + "U", visited);
        solve(mat, i+1, j, n, res, out + "D", visited);
        solve(mat, i, j+1, n, res, out + "R", visited);
        solve(mat, i, j-1, n, res, out + "L", visited);
        visited[i][j] = false;
    }
}
