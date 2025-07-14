package BinarySearch.BinarySearchOnAnswers;
//410. Split Array Largest Sum https://leetcode.com/problems/split-array-largest-sum/description/
//        Solved
//        Hard
//        Topics
//        Companies
//        Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
//
//        Return the minimized largest sum of the split.
//
//        A subarray is a contiguous part of the array.
//
//
//
//        Example 1:
//
//        Input: nums = [7,2,5,10,8], k = 2
//        Output: 18
//        Explanation: There are four ways to split nums into two subarrays.
//        The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
//        Example 2:
//
//        Input: nums = [1,2,3,4,5], k = 2
//        Output: 9
//        Explanation: There are four ways to split nums into two subarrays.
//        The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
//
//
//        Constraints:
//
//        1 <= nums.length <= 1000
//        0 <= nums[i] <= 106
//        1 <= k <= min(50, nums.length)
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            high += nums[i];
        }
        int res = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(nums, n, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private boolean isPossible(int[] arr, int n, int k, int maxSum) {
        int kCount = 1;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] > maxSum) return false;
            sum += arr[i];
            if(sum > maxSum) {
                kCount++;
                sum = arr[i];
            }
        }
        if(kCount > k) return false;
        return true;
    }
}
