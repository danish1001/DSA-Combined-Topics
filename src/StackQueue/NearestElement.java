package StackQueue;

import java.util.Stack;

public class NearestElement {
    public int[] prevNearestSmallerElement(int[] arr, int n) {
        int[] pse = new int[n];
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                pse[index++] = -1;
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    pse[index++] = -1;
                } else {
                    pse[index++] = stack.peek();
                }
            }
            stack.add(i);
        }
        return pse;
    }

    public int[] nextNearestSmallerElement(int[] arr, int n) {
        int[] nse = new int[n];
        int index = n-1;
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                nse[index--] = n;
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    nse[index--] = n;
                } else {
                    nse[index--] = stack.peek();
                }
            }
            stack.add(i);
        }
        return nse;
    }
}
