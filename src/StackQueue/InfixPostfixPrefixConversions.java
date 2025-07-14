package StackQueue;
import java.util.Stack;

public class InfixPostfixPrefixConversions {

    public String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        String res = "";
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                res += ch;
            } else if(ch == '(') {
                stack.add(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
                    res += stack.pop();
                }
                stack.add(ch);
            }
        }
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }

    public String infixToPrefix(String s) {
        // algorithm:
        // reverse string with bracket correction
        // do infix to postfix conversion: i.e. controlled conversion
        // controlled conversion means we will pop only if prec(currChar) < prec(stack.peek()) i.e. strictly smaller
        // reverse output string with bracket correction
        // voila!

        s = reverseExpression(s);
        String res = "";
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(isOperand(ch)) {
                res += ch;
            } else if(ch == '(') {
                stack.add(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }
                stack.pop();
            } else if(ch == '^') {
                while(!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
                    res += stack.pop();
                }
            } else {
                while(!stack.isEmpty() && prec(ch) < prec(stack.peek())) {
                    res += stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) res += stack.pop();

        return reverseExpression(res);
    }

    public String postfixToInfix(String s) {
        // algorithm:
        // create stack
        // run for loop from 0 to n, add operands into stack
        // when encounter operator:
        //      1. pop two elements from stack
        //      2. put operator between the above popped two elements and add second popped element then first popped element
        //      3. wrap it around brackets and push it back to stack
        // repeat step until string is traversed

        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(isOperand(ch)) {
                stack.push("" + ch);
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.add("(" + b + ch + a + ")");
            }
        }
        return stack.peek();
    }

    public String prefixToInfix(String pre_exp) {
        // algorithm:
        // create stack
        // run for loop from n-1 to 0, add operands into stack
        // when encounter operator:
        //      1. pop two elements from stack
        //      2. put operator between the above popped two elements and add first popped element then second popped element
        //      3. wrap it around brackets and push it back to stack
        // repeat step until string is traversed

        Stack<String> stack = new Stack<>();

        for(int i=pre_exp.length()-1; i>=0 ;i--) {
            char ch = pre_exp.charAt(i);
            if(isOperand(ch)) {
                stack.add("" + ch);
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.add("(" + a + ch + b + ")");
            }
        }
        return stack.peek();
    }

    public String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<post_exp.length(); i++) {
            char ch = post_exp.charAt(i);
            if(isOperand(ch)) {
                stack.add("" + ch);
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.add(ch + b + a);
            }
        }
        return stack.peek();
    }

    public String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();

        for(int i=pre_exp.length()-1; i>=0; i--) {
            char ch = pre_exp.charAt(i);
            if(isOperand(ch)) {
                stack.add("" + ch);
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.add(a + b + ch);
            }
        }
        return stack.peek();
    }

    private String reverseExpression(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i=0; i<n/2; i++) {
            if(arr[i] == '(') arr[i] = ')';
            if(arr[i] == ')') arr[i] = '(';
            swap(arr, i, n-i-1);
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int prec(char ch) {
        if(ch == '^') return 3;
        if(ch == '/' || ch == '*') return 2;
        if(ch == '-' || ch == '+') return 1;
        return 0;
    }


    private boolean isOperand(char ch) {
        if(ch >= 'A' && ch <= 'Z') return true;
        if(ch >= 'a' && ch <= 'z') return true;
        return false;
    }
}
