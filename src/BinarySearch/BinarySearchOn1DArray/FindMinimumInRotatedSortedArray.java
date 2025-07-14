package BinarySearch.BinarySearchOn1DArray;
//153. Find Minimum in Rotated Sorted Array https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//        [4,5,6,7,0,1,2] if it was rotated 4 times.
//        [0,1,2,4,5,6,7] if it was rotated 7 times.
//        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//        Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//        You must write an algorithm that runs in O(log n) time.
//
//
//
//        Example 1:
//
//        Input: nums = [3,4,5,1,2]
//        Output: 1
//        Explanation: The original array was [1,2,3,4,5] rotated 3 times.
//        Example 2:
//
//        Input: nums = [4,5,6,7,0,1,2]
//        Output: 0
//        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
//        Example 3:
//
//        Input: nums = [11,13,15,17]
//        Output: 11
//        Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
//
//
//        Constraints:
//
//        n == nums.length
//        1 <= n <= 5000
//        -5000 <= nums[i] <= 5000
//        All the integers of nums are unique.
//        nums is sorted and rotated between 1 and n times.
public class FindMinimumInRotatedSortedArray {
    public int findMin_sol1(int[] nums) {
        int low = 0, high = nums.length-1;
        int res = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[low] <= nums[mid]) {
                res = Math.min(nums[low], res);
                low = mid + 1;
            } else {
                res = Math.min(nums[mid], res);
                high = mid - 1;
            }
        }
        return res;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int findMin_sol2(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        if(low == high || nums[low] < nums[high]) return nums[low];

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[low] < nums[high]) return nums[low];

            if(mid == 0) {
                if(nums[mid] > nums[mid+1]) return nums[mid+1];
                return nums[mid];
            } else if(mid == n-1) {
                if(nums[mid-1] > nums[mid]) return nums[mid];
                return nums[mid+1];
            } else if(nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1]) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
