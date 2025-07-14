package Array.Hard;

//152. Maximum Product Subarray : https://leetcode.com/problems/maximum-product-subarray/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an integer array nums, find a subarray that has the largest product, and return the product.
//
//        The test cases are generated so that the answer will fit in a 32-bit integer.
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.
//        Example 2:
//
//        Input: nums = [-2,0,-1]
//        Output: 0
//        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
//
//        Constraints:
//
//        1 <= nums.length <= 2 * 104
//        -10 <= nums[i] <= 10
//        The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] text = new int[(int) 1e7];
        int n = nums.length;
        int left = 1, right = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            left *= nums[i];
            right *= nums[n-i-1];
            max = Math.max(left, max);
            max = Math.max(right, max);
            if(left == 0) left = 1;
            if(right == 0) right = 1;
        }
        return max;
    }
}
