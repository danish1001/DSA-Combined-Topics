package Strings.Hard;

import java.util.Arrays;

//Count Palindromic Subsequences https://www.geeksforgeeks.org/problems/count-palindromic-subsequences/1
//        Difficulty: MediumAccuracy: 17.0%Submissions: 151K+Points: 4
//        Given a string s, you have to find the number of palindromic subsequences (need not necessarily be distinct) present in the string s.
//
//        Examples:
//
//        Input: s = "abcd"
//        Output: 4
//        Explanation: palindromic subsequence are : 'a' ,'b', 'c' ,'d'
//        Input: s = "aab"
//        Output: 4
//        Explanation: palindromic subsequence are : 'a', 'a', 'b', 'aa'
//        Input: s = "b"
//        Output: 1
//        Explanation: palindromic subsequence are : 'b'
//        Constraints:
//        1<= s.size() <=30
//
//        Expected Complexities
//        Time Complexity: O(n^2)
//        Auxiliary Space: O(n^2)
public class CountPalindromicSubsequences_HARD {
    int countPS_sol1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(s, 0, n-1, dp);
    }
    private int solve(String s, int i, int j, int[][] dp) {
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 1 + solve(s, i+1, j, dp) + solve(s, i, j-1, dp);
        } else {
            return dp[i][j] = solve(s, i+1, j, dp) + solve(s, i, j-1, dp) - solve(s, i+1, j-1, dp);
        }
    }
    // ---------------------------------------------------------------------------------------------------
    int countPS_sol2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(i > j) continue;
                if(i == j) {
                    dp[i][j] = 1;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1];
    }
    // ---------------------------------------------------------------------------------------------------
    int countPS_sol3(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int diag=0; diag<n; diag++) {
            for(int i=0, j=diag; i<n && j<n; i++, j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1];
    }

}
