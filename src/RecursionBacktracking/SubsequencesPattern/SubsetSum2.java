package RecursionBacktracking.SubsequencesPattern;

import java.util.*;
//90. Subsets II https://leetcode.com/problems/subsets-ii/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,2]
//        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
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
public class SubsetSum2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void subsetsWithDup(int[] nums, int i, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for(int index = i; index < nums.length; index++) {
            if(index > i && nums[index-1] == nums[index]) continue;
            list.add(nums[index]);
            subsetsWithDup(nums, index+1, list, res);
            list.remove(list.size()-1);
        }
    }
}
