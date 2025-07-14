package RecursionBacktracking.SubsequencesPattern;

import java.util.Arrays;

//Perfect Sum Problem https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
//        Difficulty: MediumAccuracy: 20.58%Submissions: 515K+Points: 4
//        Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.
//
//        Examples:
//
//        Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
//        Output: 3
//        Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
//        Input: arr[] = [2, 5, 1, 4, 3], target = 10
//        Output: 3
//        Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
//        Input: arr[] = [5, 7, 8], target = 3
//        Output: 0
//        Explanation: There are no subsets of the array that sum up to the target 3.
//        Input: arr[] = [35, 2, 8, 22], target = 0
//        Output: 1
//        Explanation: The empty subset is the only subset with a sum of 0.
//        Constraints:
//        1 ≤ arr.size() ≤ 103
//        0 ≤ arr[i] ≤ 103
//        0 ≤ target ≤ 103
//
//        Expected Complexities
//        Time Complexity: O(n*target)
//        Auxiliary Space: O(n*target)
public class CountAllSubsequencesWithSumK {

    public int perfectSum_recursive(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(nums, n-1, target, dp);
    }

    private int solve(int[] nums, int n, int target, int[][] dp) {
        if(n == 0) {
            if(target == nums[0] && nums[0] == 0) return 2;
            if(target == nums[0] || target == 0) return 1;
            return 0;
        }
        if(dp[n][target] != -1) return dp[n][target];
        int pick = 0;
        if(target-nums[n] >= 0) pick = solve(nums, n-1, target-nums[n], dp);
        int notPick = solve(nums, n-1, target, dp);

        return dp[n][target] = pick + notPick;
    }

    //-------------------------------------------------------------------------------------------------

    public int perfectSum_tabulation(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        dp[0][0] = 1;
        if(nums[0] <= target) dp[0][nums[0]] = 1;
        if(nums[0] == 0) dp[0][0] = 2;

        for(int i=1; i<n; i++) {
            for(int j=0; j<=target; j++) {

                int pick = 0;
                if(j-nums[i] >= 0) pick = dp[i-1][j-nums[i]];
                int notPick = dp[i-1][j];

                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][target];
    }
}
