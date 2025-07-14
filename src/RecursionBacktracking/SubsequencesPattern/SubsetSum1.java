package RecursionBacktracking.SubsequencesPattern;

import java.util.*;
//Subset Sums https://www.geeksforgeeks.org/problems/subset-sums2234/1
//        Difficulty: MediumAccuracy: 72.55%Submissions: 160K+Points: 4
//        Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
//
//        Examples:
//
//        Input: arr[] = [2, 3]
//        Output: [0, 2, 3, 5]
//        Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
//        Input: arr[] = [1, 2, 1]
//        Output: [0, 1, 1, 2, 2, 3, 3, 4]
//        Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2), and their combinations.
//        Input: arr[] = [5, 6, 7]
//        Output: [0, 5, 6, 7, 11, 12, 13, 18]
//        Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.
//        Constraints:
//        1 ≤ arr.size() ≤ 15
//        0 ≤ arr[i] ≤ 104

public class SubsetSum1 {
    private void subsetSumsPickNotPick(int[] arr, int n, int sum, List<Integer> res) {
        if(n < 0) {
            res.add(sum);
            return;
        }
        subsetSumsPickNotPick(arr, n-1, sum+arr[n], res);
        subsetSumsPickNotPick(arr, n-1, sum, res);
    }

    //--------------------------------------------------------------------------------------------
    private void subsetSumsRecursionLoop(int[] arr, int n, int sum, List<Integer> res) {
        res.add(sum);
        for(int index=n; index>=0; index--) {
            subsetSumsRecursionLoop(arr, index-1, sum + arr[index], res);
        }
    }
}
