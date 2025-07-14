package StackQueue.Questions;

import java.util.Stack;

public class MaximumAreaOfHistogram {

    // Most Optimised solution
    public int largestRectangleAreaOptimised(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<=n; i++) {
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int currHeight = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                maxArea = Math.max((currHeight * width), maxArea);
            }
            stack.add(i);
        }
        return maxArea;
    }

    // Regular Solution
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, res = 0;

        int[] nsl = nearestSmallerToLeft(heights, n);
        int[] nsr = nearestSmallerToRight(heights, n);

        for(int i=0; i<n; i++) {
            res = Math.max(res, heights[i] * (nsr[i] - nsl[i] - 1));
        }
        return res;
    }

    public int[] nearestSmallerToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int index = 0;

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                res[index++] = -1;
            } else {
                while(!stack.isEmpty() &&  arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[index++] = -1;
                } else {
                    res[index++] = stack.peek();
                }
            }
            stack.add(i);
        }
        return res;
    }

    public int[] nearestSmallerToRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int index = n-1;

        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                res[index--] = n;
            } else {
                while(!stack.isEmpty() &&  arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[index--] = n;
                } else {
                    res[index--] = stack.peek();
                }
            }
            stack.add(i);
        }
        return res;
    }
}
