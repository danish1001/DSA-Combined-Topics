package StackQueue.Questions;

import StackQueue.NearestElement;

public class SumOfSubArrayMinimums {
    public int sumSubArrayMinimums(int[] arr, int n) {
        NearestElement nearestElement = new NearestElement();
        int mod = (int) 1e9 + 7;
        int[] nse = nearestElement.nextNearestSmallerElement(arr, n);
        int[] pse = nearestElement.prevNearestSmallerElement(arr, n);

        int minSum = 0;
        for(int i=0; i<n; i++) {
            // number of subsets including element at i is (number of elements before i (including i) * number of elements after i(including i))
            long left = (long) (i - pse[i]);
            long right = (long) (nse[i] - i);

            long mul = left * right * (long) arr[i] % mod;

            minSum = (minSum + (int) mul) % mod;
        }
        return minSum;
    }
}
