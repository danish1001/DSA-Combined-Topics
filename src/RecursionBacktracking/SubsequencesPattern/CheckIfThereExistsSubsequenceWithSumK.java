package RecursionBacktracking.SubsequencesPattern;
// Subset Sum https://www.naukri.com/code360/problems/subset-sum_630213
//         Moderate
//         80/80
//         Average time to solve is 25m
//         Contributed by
//         120 upvotes
//         Problem statement
//         You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.
//
//
//
//         For Example
//         'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
//         Subset [2, 3] has sum equal to 'K'.
//         So our answer is True.
//         Detailed explanation ( Input/output format, Notes, Images )
//         Sample Input 1 :
//         4 13
//         4 3 5 2
//         Sample Output 1 :
//         No
//         Sample Input 2 :
//         5 14
//         4 2 5 6 7
//         Sample Output 2 :
//         Yes
//         Constraints :
//         1 <= 'N' <= 10^3
//         1 <= 'A[i]' <= 10^3
//         1 <= 'K' <= 10^3
//         Time Limit: 1 sec
public class CheckIfThereExistsSubsequenceWithSumK {
    public static boolean isSubsetPresent(int n, int k, int[] a) {
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(k-a[0] >= 0) dp[0][a[0]] = true;

        for(int i=1; i<n; i++) {
            for(int j=0; j<=k; j++) {
                boolean pick = false;
                if(j - a[i] >= 0) pick = dp[i-1][j-a[i]];
                boolean notPick = dp[i-1][j];
                dp[i][j] = pick | notPick;
            }
        }
        return dp[n-1][k];
    }
}
