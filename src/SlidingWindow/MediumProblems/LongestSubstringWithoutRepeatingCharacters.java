package SlidingWindow.MediumProblems;

import java.util.HashSet;
import java.util.Set;

//3. Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Given a string s, find the length of the longest substring without duplicate characters.
//
//
//
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//        Constraints:
//
//        0 <= s.length <= 5 * 104
//        s consists of English letters, digits, symbols and spaces.
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring_sol1(String s) {
        int i = 0, j = 0, n = s.length();
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(j < n) {
            if(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                res = Math.max(res, j-i+1);
                j++;
            }
        }
        return res;
    }
}
