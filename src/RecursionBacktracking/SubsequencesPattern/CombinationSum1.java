package RecursionBacktracking.SubsequencesPattern;

import java.util.*;
//39. Combination Sum https://leetcode.com/problems/combination-sum/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//        The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//
//
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7
//        Output: [[2,2,3],[7]]
//        Explanation:
//        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//        7 is a candidate, and 7 = 7.
//        These are the only two combinations.
//        Example 2:
//
//        Input: candidates = [2,3,5], target = 8
//        Output: [[2,2,2,2],[2,3,3],[3,5]]
//        Example 3:
//
//        Input: candidates = [2], target = 1
//        Output: []
//
//
//        Constraints:
//
//        1 <= candidates.length <= 30
//        2 <= candidates[i] <= 40
//        All elements of candidates are distinct.
//        1 <= target <= 40
public class CombinationSum1 {
    public List<List<Integer>> combinationSum_sol1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve_sol1(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    private void solve_sol1(int[] candidates, int i, int target, List<Integer> list, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(i == candidates.length) return;

        list.add(candidates[i]);
        solve_sol1(candidates, i, target-candidates[i], list, res);
        list.remove(list.size()-1);
        solve_sol1(candidates, i+1, target, list, res);
    }

    // -----------------------------------------------------------------------------

    public List<List<Integer>> combinationSum_sol2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve_sol2(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    private void solve_sol2(int[] candidates, int i, int target, List<Integer> list, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int index=i; index<candidates.length; index++) {
            list.add(candidates[index]);
            solve_sol2(candidates, index, target-candidates[index], list, res);
            list.remove(list.size()-1);
        }
    }
}
