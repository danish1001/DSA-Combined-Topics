package Strings.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//242. Valid Anagram https://leetcode.com/problems/valid-anagram/
//        Solved
//        Easy
//        Topics
//        Companies
//        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//
//        Output: true
//
//        Example 2:
//
//        Input: s = "rat", t = "car"
//
//        Output: false
//
//
//
//        Constraints:
//
//        1 <= s.length, t.length <= 5 * 104
//        s and t consist of lowercase English letters.
//
//
//        Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
public class ValidAnagram {
    public boolean isAnagram_sol1(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }

    public boolean isAnagram_sol2(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0; i<ch1.length; i++) {
            if(ch1[i] != ch2[i]) return false;
        }

        return true;
    }
    public boolean isAnagram_sol3(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(t.charAt(i))) return false;
            int f = map.get(t.charAt(i));
            if(f == 1) map.remove(t.charAt(i));
            else map.put(t.charAt(i), f-1);
        }


        return true;
    }
}
