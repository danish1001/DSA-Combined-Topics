package SlidingWindow.HardProblems;

import java.util.HashMap;
import java.util.Map;
//992. Subarrays with K Different Integers https://leetcode.com/problems/subarrays-with-k-different-integers/
//        Solved
//        Hard
//        Topics
//        Companies
//        Hint
//        Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//        A good array is an array where the number of different integers in that array is exactly k.
//
//        For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//        A subarray is a contiguous part of an array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,1,2,3], k = 2
//        Output: 7
//        Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
//        Example 2:
//
//        Input: nums = [1,2,1,3,4], k = 3
//        Output: 3
//        Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        1 <= nums[i], k <= nums.length
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct_sum1(int[] nums, int k) {
        return atleast(nums, k) - atleast(nums, k+1);
    }
    private int atleast(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = nums.length;
        int res = 0;

        while(i < n) {
            while(j < n && map.size() < k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            if(j == n && map.size() < k) break;
            res += n-j+1;
            remove(map, nums[i]);
            i++;
        }
        return res;
    }
    private void remove(Map<Integer, Integer> map, int ele) {
        int f = map.get(ele);
        if(f == 1) map.remove(ele);
        else map.put(ele, f-1);
    }
    //--------------------------------------------------------------------------------------------------
    public int subarraysWithKDistinct_sol2(int[] nums, int k) {
        int i = 0, j = 0, ind = 0, n = nums.length;
        if(k == 1) return solve(nums, n);
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int res = 0;

        while(ind < n) {
            while(i < n && map1.size() < k-1) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
                i++;
            }
            while(i < n && map1.containsKey(nums[i])) {
                map1.put(nums[i], map1.get(nums[i]) + 1);
                i++;
            }

            while(j < n && map2.size() < k) {
                map2.put(nums[j], map2.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            while(j < n && map2.containsKey(nums[j])) {
                map2.put(nums[j], map2.get(nums[j]) + 1);
                j++;
            }

            res += j-i;
            remove(map1, nums[ind]);
            remove(map2, nums[ind]);
            ind++;
        }
        return res;
    }
    private int solve(int[] nums, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int res = 0;

        while(i < n) {
            if(j < n && map.size() < 1) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            while(j < n && map.containsKey(nums[j])) {
                map.put(nums[j], map.get(nums[j]) + 1);
                j++;
            }
            res += j-i;
            remove(map, nums[i]);
            i++;
        }
        return res;
    }
}
