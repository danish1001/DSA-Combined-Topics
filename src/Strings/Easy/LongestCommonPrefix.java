package Strings.Easy;
//14. Longest Common Prefix https://leetcode.com/problems/longest-common-prefix/editorial/
//        Solved
//        Easy
//        Topics
//        Companies
//        Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//
//
//        Example 1:
//
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//
//
//        Constraints:
//
//        1 <= strs.length <= 200
//        0 <= strs[i].length <= 200
//        strs[i] consists of only lowercase English letters if it is non-empty.
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int n = strs.length, m = Integer.MAX_VALUE;

        for(int i=0; i<strs.length; i++) {
            m = Math.min(m, strs[i].length());
        }

        for(int i=0; i<m; i++) {
            char ch = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(ch != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
