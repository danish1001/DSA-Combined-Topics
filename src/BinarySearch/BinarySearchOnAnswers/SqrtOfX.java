package BinarySearch.BinarySearchOnAnswers;
//69. Sqrt(x)
//        Solved
//        Easy
//        Topics
//        Companies
//        Hint
//        Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//
//        You must not use any built-in exponent function or operator.
//
//        For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//
//
//        Example 1:
//
//        Input: x = 4
//        Output: 2
//        Explanation: The square root of 4 is 2, so we return 2.
//        Example 2:
//
//        Input: x = 8
//        Output: 2
//        Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
//
//
//        Constraints:
//
//        0 <= x <= 231 - 1
public class SqrtOfX {

    public int mySqrt(int x) {
        long low = 0, high = x;
        long res = x;

        while(low <= high) {
            long mid = low + (high-low)/2;
            if((mid*mid) <= (long) x) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) res;
    }
}
