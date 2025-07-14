package RecursionBacktracking.Basics;

import java.util.Stack;

public class ReverseStack {
    public void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int topElement = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, topElement);
    }
    private void insertAtBottom(Stack<Integer> stack, int topElement) {
        if(stack.isEmpty()) {
            stack.push(topElement);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, topElement);
        stack.push(temp);
    }
}
