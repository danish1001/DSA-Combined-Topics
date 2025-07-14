package RecursionBacktracking.SubsequencesPattern;

import java.util.*;
//40. Combination Sum II https://leetcode.com/problems/combination-sum-ii/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note: The solution set must not contain duplicate combinations.
//
//
//
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]
//        Example 2:
//
//        Input: candidates = [2,5,2,1,2], target = 5
//        Output:
//        [
//        [1,2,2],
//        [5]
//        ]
//
//
//        Constraints:
//
//        1 <= candidates.length <= 100
//        1 <= candidates[i] <= 50
//        1 <= target <= 30
public class CombinationSum2 {
//    Given a collection of candidate numbers (candidates) and a target number (target),
//    find all unique combinations in candidates where the candidate numbers sum to target.
//    Each number in candidates may only be used once in the combination.
//    Note: The solution set must not contain duplicate combinations.

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    private void solve(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(i > index && candidates[i-1] == candidates[i]) continue;
            list.add(candidates[i]);
            solve(candidates, i+1, target-candidates[i], list, res);
            list.remove(list.size()-1);
        }
    }
}
