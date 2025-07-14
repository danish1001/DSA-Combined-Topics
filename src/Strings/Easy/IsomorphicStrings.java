package Strings.Easy;
import java.util.*;

//205. Isomorphic Strings https://leetcode.com/problems/isomorphic-strings/description/
//        Solved
//        Easy
//        Topics
//        Companies
//        Given two strings s and t, determine if they are isomorphic.
//
//        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//        Example 1:
//
//        Input: s = "egg", t = "add"
//
//        Output: true
//
//        Explanation:
//
//        The strings s and t can be made identical by:
//
//        Mapping 'e' to 'a'.
//        Mapping 'g' to 'd'.
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//
//        Output: false
//
//        Explanation:
//
//        The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
//
//        Example 3:
//
//        Input: s = "paper", t = "title"
//
//        Output: true
//
//
//
//        Constraints:
//
//        1 <= s.length <= 5 * 104
//        t.length == s.length
//        s and t consist of any valid ascii character.
public class IsomorphicStrings {
    public boolean isIsomorphic_sol1(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        int[] map = new int[256];
        int[] set = new int[256];
        Arrays.fill(map, -1);
        Arrays.fill(set, -1);

        for(int i=0; i<n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map[ch1] >= 0) {
                if(map[ch1] != ch2) return false;
            } else {
                map[ch1] = ch2;
                if(set[ch2] >= 0) return false;
                set[ch2] = ch2;
            }
        }
        return true;
    }

    public boolean isIsomorphic_sol2(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map.containsKey(ch1)) {
                if(map.get(ch1) != ch2) return false;
            } else {
                map.put(ch1, ch2);
                if(set.contains(ch2)) return false;
                set.add(ch2);
            }
        }
        return true;
    }
}
