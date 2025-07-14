package Strings.Medium;
//5. Longest Palindromic Substring https://leetcode.com/problems/longest-palindromic-substring/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Given a string s, return the longest palindromic substring in s.
//
//
//
//        Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
//        Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"
//
//
//        Constraints:
//
//        1 <= s.length <= 1000
//        s consist of only digits and English letters.
public class LongestPalindromicSubstring_ExpansionMethod {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        for(int i=0; i<n; i++) {
            String a = getMaxPal(s, i, i);
            String b = getMaxPal(s, i, i+1);
            if(a.length() > res.length()) res = a;
            if(b.length() > res.length()) res = b;
        }
        return res;
    }
    private String getMaxPal(String s, int j, int k) {
        int n = s.length();
        int max = 0;
        int si = 0, se = 0;
        while(j >= 0 && k < n) {
            if(s.charAt(j) == s.charAt(k)) {
                if(k-j+1 > max) {
                    max = k-j+1;
                    si = j;
                    se = k;
                }
                j--;
                k++;
            } else {
                break;
            }
        }
        return s.substring(si, se+1);
    }
}
