package Strings.Easy;
//1021. Remove Outermost Parentheses https://leetcode.com/problems/remove-outermost-parentheses/description/
//        Solved
//        Easy
//        Topics
//        Companies
//        Hint
//        A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
//
//        For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//        A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
//
//        Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
//
//        Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
//
//
//
//        Example 1:
//
//        Input: s = "(()())(())"
//        Output: "()()()"
//        Explanation:
//        The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
//        After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
//        Example 2:
//
//        Input: s = "(()())(())(()(()))"
//        Output: "()()()()(())"
//        Explanation:
//        The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
//        After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
//        Example 3:
//
//        Input: s = "()()"
//        Output: ""
//        Explanation:
//        The input string is "()()", with primitive decomposition "()" + "()".
//        After removing outer parentheses of each part, this is "" + "" = "".
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//        s[i] is either '(' or ')'.
//        s is a valid parentheses string.
public class RemoveOutermostParenthesis {
    public String removeOuterParentheses_sol1(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, n = s.length();
        int open = 0;

        while(j < n) {
            char ch = s.charAt(j);
            if(ch == '(') {
                open++;
            } else {
                open--;
            }
            if(open == 0) {
                sb.append(s.substring(i+1, j));
                i = j+1;
            }
            j++;
        }
        return sb.toString();
    }
// ---------------------------------------------------------------------------------------------------
    public String removeOuterParentheses_sol2(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0, close = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
                if(open > 1) sb.append(ch);
            } else {
                close++;
                if(open == close) {
                    open = close = 0;
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
