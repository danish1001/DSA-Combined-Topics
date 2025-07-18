package Strings.Hard;
//1392. Longest Happy Prefix https://leetcode.com/problems/longest-happy-prefix/
//        Solved
//        Hard
//        Topics
//        Companies
//        Hint
//        A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
//
//        Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
//
//
//
//        Example 1:
//
//        Input: s = "level"
//        Output: "l"
//        Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
//        Example 2:
//
//        Input: s = "ababab"
//        Output: "abab"
//        Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//        s contains only lowercase English letters.
public class LongestHappyPrefix {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] LCS = lcs(s, n);
        return s.substring(n-LCS[n-1], n);
    }
    private int[] lcs(String s, int n) {
        int[] LCS = new int[n];
        int occ = 0, i = 1;
        while(i < n) {
            if(s.charAt(occ) == s.charAt(i)) {
                LCS[i] = occ+1;
                occ++;
                i++;
            } else {
                if(occ != 0) {
                    occ = LCS[occ-1];
                } else {
                    LCS[i] = 0;
                    i++;
                }
            }
        }
        return LCS;
    }
}
