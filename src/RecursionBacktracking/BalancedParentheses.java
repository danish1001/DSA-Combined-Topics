package RecursionBacktracking;

import java.util.Stack;

public class BalancedParentheses {
    public void printBalancedParentheses(int open, int close, int n, String output) {
        if(open > n || close > n) return;
        if(open == n && close == n) {
            if(isBalanced(output))
                System.out.println(output);
            return;
        }
        printBalancedParentheses(open+1, close, n, output + '(');
        printBalancedParentheses(open, close+1, n, output + ')');
    }

    private boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        int i = 0, n = input.length();

        while(i < n) {
            char ch = input.charAt(i);
            if(ch == '(') {
                stack.push(ch);
                i++;
            } else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                while(i < n && input.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    i++;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
