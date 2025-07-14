package Strings.Hard;
//38. Count and Say https://leetcode.com/problems/count-and-say/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//
//        countAndSay(1) = "1"
//        countAndSay(n) is the run-length encoding of countAndSay(n - 1).
//        Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
//
//        Given a positive integer n, return the nth element of the count-and-say sequence.
//
//
//
//        Example 1:
//
//        Input: n = 4
//
//        Output: "1211"
//
//        Explanation:
//
//        countAndSay(1) = "1"
//        countAndSay(2) = RLE of "1" = "11"
//        countAndSay(3) = RLE of "11" = "21"
//        countAndSay(4) = RLE of "21" = "1211"
//        Example 2:
//
//        Input: n = 1
//
//        Output: "1"
//
//        Explanation:
//
//        This is the base case.
//
//
//
//        Constraints:
//
//        1 <= n <= 30

public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        if(n == 1) return res;
        for(int i=2; i<=n; i++) {
            res = solve(res);
        }
        return res;
    }
    private String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char say = s.charAt(0);

        for(int i=1; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == say) {
                count++;
            } else {
                sb.append(count);
                sb.append(say);
                say = ch;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(say);
        return sb.toString();
    }
}
