package Strings.Hard;

import java.util.Stack;

// Count the Reversals https://www.geeksforgeeks.org/problems/count-the-reversals0401/1
//Difficulty: MediumAccuracy: 51.88%Submissions: 72K+Points: 4Average Time: 15m
//Given a string s consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals required to convert the string into a balanced expression. A reversal means changing '{' to '}' or vice-versa.
//
//Examples:
//
//Input: s = "}{{}}{{{"
//Output: 3
//Explanation: One way to balance is:
//"{{{}}{}}". There is no balanced sequence
//that can be formed in lesser reversals.
//Input: s = "{{}{{{}{{}}{{"
//Output: -1
//Explanation: There's no way we can balance
//this sequence of braces.
//Constraints:
//1 ≤ |s| ≤ 105
public class CountTheReversals {
    public int countMinReversals(String s) {
        int close = 0, open = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '{') {
                stack.add(ch);
            } else if(ch == '}' && !stack.isEmpty()) {
                stack.pop();
            } else {
                close++;
            }
        }
        open = stack.size();
        if((open+close) % 2 != 0) return -1;
        return (open+1) / 2 + (close+1) / 2;
    }
}
