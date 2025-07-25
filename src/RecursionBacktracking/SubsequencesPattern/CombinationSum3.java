package RecursionBacktracking.SubsequencesPattern;

import java.util.*;
//216. Combination Sum III https://leetcode.com/problems/combination-sum-iii/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//        Only numbers 1 through 9 are used.
//        Each number is used at most once.
//        Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
//
//
//        Example 1:
//
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
//        Explanation:
//        1 + 2 + 4 = 7
//        There are no other valid combinations.
//        Example 2:
//
//        Input: k = 3, n = 9
//        Output: [[1,2,6],[1,3,5],[2,3,4]]
//        Explanation:
//        1 + 2 + 6 = 9
//        1 + 3 + 5 = 9
//        2 + 3 + 4 = 9
//        There are no other valid combinations.
//        Example 3:
//
//        Input: k = 4, n = 1
//        Output: []
//        Explanation: There are no valid combinations.
//        Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
//
//
//        Constraints:
//
//        2 <= k <= 9
//        1 <= n <= 60
public class CombinationSum3 {
//    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//          Only numbers 1 through 9 are used.
//          Each number is used at most once.
//     Return a list of all possible valid combinations.
//     The list must not contain the same combination twice, and the combinations may be returned in any order.

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum3(int k, int n, int i, List<Integer> list, List<List<Integer>> res) {
        if(n == 0 && k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(n < 0 || k < 0) return;

        for(int num=i; num<=9; num++) {
            list.add(num);
            combinationSum3(k-1, n-num, num+1, list, res);
            list.remove(list.size()-1);
        }
    }
}
