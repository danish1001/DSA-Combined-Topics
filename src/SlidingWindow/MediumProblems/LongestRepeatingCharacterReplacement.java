package SlidingWindow.MediumProblems;
//424. Longest Repeating Character Replacement
//        Solved
//        Medium
//        Topics
//        Companies
//        You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//        Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//
//
//        Example 1:
//
//        Input: s = "ABAB", k = 2
//        Output: 4
//        Explanation: Replace the two 'A's with two 'B's or vice versa.
//        Example 2:
//
//        Input: s = "AABABBA", k = 1
//        Output: 4
//        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//        The substring "BBBB" has the longest repeating letters, which is 4.
//        There may exists other ways to achieve this answer too.
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//        s consists of only uppercase English letters.
//        0 <= k <= s.length
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement_sol1(String s, int k) {
        int[] map = new int[26];
        int i = 0, j = 0, n = s.length();
        int maxFreq = 0;
        int res = 0;

        while(j < n) {
            map[s.charAt(j)-'A']++;
            // we will check on the jth character for best chance
            maxFreq = Math.max(maxFreq, map[s.charAt(j)-'A']);

            if(j-i+1 - maxFreq <= k) {
                res = Math.max(res, j-i+1);
            } else {
                map[s.charAt(i)-'A']--;
                // here we are setting it to zero, certainly there will be someone maximum after this
                // but will be certainly smaller than the current thus there is absolutely no need
                // to count the maxFreq of that character which will never contribute
                // Thus we will check on the next jth character for best chance
                maxFreq = 0;
                i++;
            }
            j++;
        }
        return res;
    }

    // ---------------------------------------------------------------------------------------------------------
    public int characterReplacement_sol2(String s, int k) {
        int res = 0;
        for(char ch='A'; ch<='Z'; ch++) {
            res = Math.max(res, solve(s, k, ch));
        }
        return res;
    }
    private int solve(String s, int k, char ch) {
        int i = 0, j = 0, n = s.length();
        int count = 0;
        int res = 0;
        while(j < n) {
            if(s.charAt(j) != ch) count++;
            if(count <= k) {
                res = Math.max(res, j-i+1);
            } else {
                while(count > k) {
                    if(s.charAt(i) != ch) count--;
                    i++;
                }
            }
            j++;
        }
        return res;
    }
}
