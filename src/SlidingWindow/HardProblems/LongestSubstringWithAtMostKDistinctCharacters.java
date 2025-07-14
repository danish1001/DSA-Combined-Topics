package SlidingWindow.HardProblems;

import java.util.HashMap;
import java.util.Map;
// Longest Substring with At Most K Distinct Characters
//         Moderate
//         80/80
//         Average time to solve is 20m
//         Contributed by
//         139 upvotes
//         Asked in companies
//         Problem statement
//         You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.
//
//         For example:
//         You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
//         Detailed explanation ( Input/output format, Notes, Images )
//         Constraints:
//         1 <= T <= 10
//         1 <= K <= 26
//         1 <= |str| <= 10^6
//
//         The string str will contain only lowercase alphabets.
//
//         Time Limit: 1 sec
//         Note:
//         You do not need to print anything. It has already been taken care of. Just implement the function.
//         Sample Input 1:
//         2
//         2
//         abbbbbbc
//         3
//         abcddefg
//         Sample Output 1:
//         7
//         4
//         Explanation:
//         For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
//
//         For the second test case, ‘str’ = ‘abcddefg’ and ‘K’ = 3, then the substrings that can be formed is [‘cdde’, ‘ddef’]. Hence the answer is 4.
//         Sample Input 2:
//         2
//         3
//         aaaaaaaa
//         1
//         abcefg
//         Sample Output 2:
//         8
//         1
//
//
//         Hints:
//         1. Try to think of a brute force approach.
//         2. Try to think of a two-pointer solution.
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int kDistinctChars_sol1(int k, String str) {
        int i = 0, j = 0, n = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        while(j < n) {
            while(j < n && map.size() < k) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
                j++;
            }
            while(j < n && map.containsKey(str.charAt(j))) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
                j++;
            }
            res = Math.max(res, j-i);
            remove(map, str.charAt(i));
            i++;
        }
        return res;
    }
    private static void remove(Map<Character, Integer> map, char ch) {
        int f = map.get(ch);
        if(f == 1) map.remove(ch);
        else map.put(ch, f-1);
    }
    // ---------------------------------------------------------------------------------
    public static int kDistinctChars_sol2(int k, String str) {
        int i = 0, j = 0, n = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        while(j < n) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            while(map.size() > k) {
                remove(map, str.charAt(i));
                i++;
            }
            res = Math.max(res, j-i+1);
            j++;
        }
        return res;
    }
}
