package Strings.Medium;
//8. String to Integer (atoi) https://leetcode.com/problems/string-to-integer-atoi/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//        The algorithm for myAtoi(string s) is as follows:
//
//        Whitespace: Ignore any leading whitespace (" ").
//        Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//        Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//        Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//        Return the integer as the final result.
//
//
//
//        Example 1:
//
//        Input: s = "42"
//
//        Output: 42
//
//        Explanation:
//
//        The underlined characters are what is read in and the caret is the current reader position.
//        Step 1: "42" (no characters read because there is no leading whitespace)
//        ^
//        Step 2: "42" (no characters read because there is neither a '-' nor '+')
//        ^
//        Step 3: "42" ("42" is read in)
//        ^
//        Example 2:
//
//        Input: s = " -042"
//
//        Output: -42
//
//        Explanation:
//
//        Step 1: "   -042" (leading whitespace is read and ignored)
//        ^
//        Step 2: "   -042" ('-' is read, so the result should be negative)
//        ^
//        Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//        ^
//        Example 3:
//
//        Input: s = "1337c0d3"
//
//        Output: 1337
//
//        Explanation:
//
//        Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//        ^
//        Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//        ^
//        Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//        ^
//        Example 4:
//
//        Input: s = "0-1"
//
//        Output: 0
//
//        Explanation:
//
//        Step 1: "0-1" (no characters read because there is no leading whitespace)
//        ^
//        Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//        ^
//        Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//        ^
//        Example 5:
//
//        Input: s = "words and 987"
//
//        Output: 0
//
//        Explanation:
//
//        Reading stops at the first non-digit character 'w'.
//
//
//
//        Constraints:
//
//        0 <= s.length <= 200
//        s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

public class ImplementAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        int sign = 1;
        if(s.charAt(0) == '+') {
            sign = 1;
            s = s.substring(1);
        } else if(s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }
        s = removeLeadingZeros(s);
        if(s.isEmpty()) return 0;

        long res = solve(s, 0, 0) * sign;
        if(res >= Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
        if(res <= Integer.MIN_VALUE && sign == -1) return Integer.MIN_VALUE;
        return (int) res;
    }

    private long solve(String s, int i, long res) {
        if(i == s.length() || i > 10) return res;
        if(!isValid(s.charAt(i))) return res;
        res = res*10 + (long) Integer.parseInt(""+s.charAt(i));
        return solve(s, i+1, res);
    }

    private boolean isValid(char ch) {
        if(ch >= '0' && ch <= '9') return true;
        return false;
    }

    private String removeLeadingZeros(String s) {
        int i = 0, n = s.length();
        while(i < n && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
