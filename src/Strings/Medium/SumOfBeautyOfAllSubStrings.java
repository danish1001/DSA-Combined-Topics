package Strings.Medium;
//1781. Sum of Beauty of All Substrings https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
//
//        For example, the beauty of "abaacc" is 3 - 1 = 2.
//        Given a string s, return the sum of beauty of all of its substrings.
//
//
//
//        Example 1:
//
//        Input: s = "aabcb"
//        Output: 5
//        Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
//        Example 2:
//
//        Input: s = "aabcbaa"
//        Output: 17
//
//
//        Constraints:
//
//        1 <= s.length <= 500
//        s consists of only lowercase English letters.
public class SumOfBeautyOfAllSubStrings {

    // just simply optimized version of below solution
    public int beautySum_sol1(String s) {
        int n = s.length();
        int res = 0;
        int[] map;

        for(int i=0; i<n; i++) {
            map = new int[26];
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                map[s.charAt(j) - 'a']++;
                max = Math.max(map[s.charAt(j) - 'a'], max);

                if(map[s.charAt(j) - 'a'] == 1) {
                    min = 1;
                } else {
                    min = Integer.MAX_VALUE;
                    for(int k=0; k<26; k++) if(map[k] != 0) min = Math.min(map[k], min);
                }
                res += (max - min);
            }
        }
        return res;
    }
    public int beautySum_sol2(String s) {
        int n = s.length();
        int res = 0;
        int[] map;

        for(int i=0; i<n; i++) {
            map = new int[26];
            for(int j=i; j<n; j++) {
                map[s.charAt(j) - 'a']++;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k=0; k<26; k++) {
                    max = Math.max(map[k], max);
                    if(map[k] != 0) min = Math.min(map[k], min);
                }
                res += (max - min);
            }
        }
        return res;
    }
}
