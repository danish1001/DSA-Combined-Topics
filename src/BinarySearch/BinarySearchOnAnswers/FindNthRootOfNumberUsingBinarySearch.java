package BinarySearch.BinarySearchOnAnswers;
//Find nth root of m
//        Difficulty: EasyAccuracy: 25.06%Submissions: 203K+Points: 2Average Time: 15m
//        You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.
//
//        Examples :
//
//        Input: n = 2, m = 9
//        Output: 3
//        Explanation: 32 = 9
//        Input: n = 3, m = 9
//        Output: -1
//        Explanation: 3rd root of 9 is not integer.
//        Input: n = 1, m = 14
//        Output: 14
//        Constraints:
//        1 <= n <= 30
//        1 <= m <= 109
public class FindNthRootOfNumberUsingBinarySearch {

    public int nthRoot(int n, int m) {
        int low = 0, high = m;
        int res = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int pow = (int) Math.pow(mid, n);

            if(pow == m) {
                return mid;
            } else if(pow < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
