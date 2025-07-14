package Strings.Hard;
//214. Shortest Palindrome https://leetcode.com/problems/shortest-palindrome/
//        Solved
//        Hard
//        Topics
//        Companies
//        You are given a string s. You can convert s to a palindrome by adding characters in front of it.
//
//        Return the shortest palindrome you can find by performing this transformation.
//
//
//
//        Example 1:
//
//        Input: s = "aacecaaa"
//        Output: "aaacecaaa"
//        Example 2:
//
//        Input: s = "abcd"
//        Output: "dcbabcd"
//
//
//        Constraints:
//
//        0 <= s.length <= 5 * 104
//        s consists of lowercase English letters only.
public class ShortestPalindrome_HARD {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = reverse(s);
        String temp = s + "#" + rev;
        int[] LPS = getLPS(temp, n+n+1);
        return reverse(s.substring(LPS[n+n], n)) + s;
    }
    private String reverse(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i=0; i<n/2; i++) {
            char temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        return String.valueOf(arr);
    }
    private int[] getLPS(String s, int n) {
        int[] lps = new int[n];
        int occ = 0, i = 1;
        while(i < n) {
            if(s.charAt(occ) == s.charAt(i)) {
                lps[i] = occ + 1;
                occ++;
                i++;
            } else {
                if(occ != 0) {
                    occ = lps[occ-1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}
