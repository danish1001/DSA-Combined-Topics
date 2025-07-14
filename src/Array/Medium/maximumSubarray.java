package Array.Medium;

//        Question(LeetCode: 53. Maximum Subarray) (https://leetcode.com/problems/maximum-subarray/description/)
//        Given an integer array nums, find the subarray with the largest sum, and return its sum.
//
//        Example 1:
//          Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//          Output: 6
//          Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//
//        Example 2:
//          Input: nums = [1]
//          Output: 1
//          Explanation: The subarray [1] has the largest sum 1.
//
//        Example 3:
//          Input: nums = [5,4,-1,7,8]
//          Output: 23
//          Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
//
//        Constraints:
//          1 <= nums.length <= 105
//          -104 <= nums[i] <= 104
//
//        Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
public class maximumSubarray {

    // Kadane's Algorithm
    public int maxSubArray_sol1(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum < 0) sum = 0;
        }
        return max;
    }
    //-----------------------------------------------------------------------
    public int maxSubArray_sol2(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    private int solve(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;

        int leftSum = solve(nums, low, mid);
        int rightSum = solve(nums, mid + 1, high);
        int crossSum = maxCrossingSum(nums, low, mid, high);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int maxCrossingSum(int[] nums, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }
}
