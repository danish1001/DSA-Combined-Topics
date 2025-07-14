package BinarySearch.BinarySearchOn1DArray;

//34. Find First and Last Position of Element in Sorted Array https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//        If target is not found in the array, return [-1, -1].
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//        Example 3:
//
//        Input: nums = [], target = 0
//        Output: [-1,-1]
//
//
//        Constraints:
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//        nums is a non-decreasing array.
//        -109 <= target <= 109

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int low=0, high=nums.length-1;
        findFirst(nums, low, high, target, res);
        findLast(nums, low, high, target, res);
        return res;
    }

    public void findFirst(int[] arr, int low, int high, int target, int[] res) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                res[0] = mid;
                high = mid - 1;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    public void findLast(int[] arr, int low, int high, int target, int[] res) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                res[1] = mid;
                low = mid + 1;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}
