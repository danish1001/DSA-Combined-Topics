package Array.Medium;
import java.util.*;

//    Question (Leetcode: 1. Two Sum) (https://leetcode.com/problems/two-sum/description/)

//    Description:
//      Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//      You may assume that each input would have exactly one solution, and you may not use the same element twice.
//      You can return the answer in any order.
//
//    Example 1:
//      Input: nums = [2,7,11,15], target = 9
//      Output: [0,1]
//      Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//    Example 2:
//      Input: nums = [3,2,4], target = 6
//      Output: [1,2]

//    Example 3:
//      Input: nums = [3,3], target = 6
//      Output: [0,1]
//
//    Constraints:
//      2 <= nums.length <= 104
//      -109 <= nums[i] <= 109
//      -109 <= target <= 109
//    Only one valid answer exists.

public class TwoSum {
    public int[] twoSum_sol1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    //-----------------------------------------------------------------------
    public int[] twoSum_sol2(int[] nums, int target) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++) arr[i] = new Pair(nums[i], i);
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.ele - p2.ele;
            }
        });

        int i=0;
        int j=n-1;

        while(i < j) {
            int sum = arr[i].ele + arr[j].ele;
            if(sum == target) {
                return new int[]{arr[i].ind, arr[j].ind};
            } else if(sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public class Pair {
        int ele;
        int ind;
        public Pair(int ele, int ind) {
            this.ele = ele;
            this.ind = ind;
        }
    }
}
