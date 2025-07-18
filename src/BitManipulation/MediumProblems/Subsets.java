package BitManipulation.MediumProblems;

import java.util.ArrayList;
import java.util.List;

//78. Subsets https://leetcode.com/problems/subsets/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//        Example 2:
//
//        Input: nums = [0]
//        Output: [[],[0]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 10
//        -10 <= nums[i] <= 10
//        All the numbers of nums are unique.
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return solve(nums, 0);
    }
    private List<List<Integer>> solve(int[] nums, int i) {
        if(i == nums.length) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> recRes = solve(nums, i+1);
        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> list: recRes) {
            result.add(list);

            List<Integer> copy = new ArrayList<>(list);
            copy.add(nums[i]);
            result.add(copy);
        }
        return result;
    }
}
