package RecursionBacktracking.Combos_HARD;

import java.util.ArrayList;
import java.util.List;

//131. Palindrome Partitioning https://leetcode.com/problems/palindrome-partitioning/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
//
//
//        Example 1:
//
//        Input: s = "aab"
//        Output: [["a","a","b"],["aa","b"]]
//        Example 2:
//
//        Input: s = "a"
//        Output: [["a"]]
//
//
//        Constraints:
//
//        1 <= s.length <= 16
//        s contains only lowercase English letters.
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s, 0, s.length(), new ArrayList<>(), res);
        return res;
    }
    private void solve(String s, int i, int n, List<String> list, List<List<String>> res) {
        if(i == n) {
            if(list.isEmpty()) return;
            res.add(new ArrayList<>(list));
            return;
        }
        for(int index=i+1; index<=n; index++) {
            if(isPalindrome(s, i, index-1)) {
                list.add(s.substring(i, index));
                solve(s, index, n, list, res);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
