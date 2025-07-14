package Array.Medium;

import java.util.HashMap;
import java.util.Map;

//560. Subarray Sum Equals K https://leetcode.com/problems/subarray-sum-equals-k/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//        A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,1], k = 2
//        Output: 2
//        Example 2:
//
//        Input: nums = [1,2,3], k = 3
//        Output: 2
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        -1000 <= nums[i] <= 1000
//        -107 <= k <= 107
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            }
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
