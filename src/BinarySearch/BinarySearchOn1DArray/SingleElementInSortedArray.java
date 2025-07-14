package BinarySearch.BinarySearchOn1DArray;
//540. Single Element in a Sorted Array https://leetcode.com/problems/single-element-in-a-sorted-array/
//        Solved
//        Medium
//        Topics
//        Companies
//        You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//        Return the single element that appears only once.
//
//        Your solution must run in O(log n) time and O(1) space.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,2,3,3,4,4,8,8]
//        Output: 2
//        Example 2:
//
//        Input: nums = [3,3,7,7,10,11,11]
//        Output: 10
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//        0 <= nums[i] <= 105

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(mid == 0 || mid == n-1) {
                return nums[mid];
            } else if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            } if(mid % 2 == 0) {
                if(nums[mid-1] != nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if(nums[mid-1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
