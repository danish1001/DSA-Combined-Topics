package RecursionBacktracking.SubsequencesPattern;

import java.util.HashMap;
import java.util.Map;

//Better String https://www.geeksforgeeks.org/problems/better-string/1
//        Difficulty: HardAccuracy: 44.5%Submissions: 102K+Points: 8Average Time: 45m
//        Given a pair of strings s1 and s2 of equal lengths, your task is to find which of the two strings has more distinct subsequences. If both strings have the same number of distinct subsequences, return s1.
//
//        Examples:
//
//        Input: s1 = "gfg", s2 = "ggg"
//        Output: "gfg"
//        Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct subsequences.
//        Input: s1 = "a", s2 = "b"
//        Output: "a"
//        Explanation: Both the strings have only 1 distinct subsequence.
//        Constraints:
//        1 <= n <= 30
//
//        Expected Complexities
//        Time Complexity: O(n)
//        Auxiliary Space: O(n)

public class BetterString_HARD {
    public static String betterString(String s1, String s2) {
        int count1 = findDistictSubsequence(s1);
        int count2 = findDistictSubsequence(s2);
        if(count1 >= count2) return s1;
        return s2;
    }

    private static int findDistictSubsequence(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            char ch = s.charAt(i-1);
            dp[i] = 2 * dp[i-1];

            if(map.containsKey(ch)) {
                dp[i] = dp[i] - dp[map.get(ch)-1];
            }
            map.put(ch, i);
        }
        return dp[n];
    }
}
