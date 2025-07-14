package RecursionBacktracking.Basics;

import java.util.Stack;

public class SortStack {
    public void sortStackUsingRecursion(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        sortStackUsingRecursion(stack);
        insertAtSortedLocation(stack, temp);
    }
    private void insertAtSortedLocation(Stack<Integer> stack, int ele) {
        if(stack.isEmpty() || stack.peek() <= ele) {
            stack.push(ele);
            return;
        }
        int temp = stack.pop();
        insertAtSortedLocation(stack, ele);
        stack.push(temp);
    }
}
