package Array.Medium;

//        Question(Leetcode: 75. Sort Colors) (https://leetcode.com/problems/sort-colors/description/)
//          Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
//          same color are adjacent, with the colors in the order red, white, and blue.
//          We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//          You must solve this problem without using the library's sort function.
//
//        Example 1:
//          Input: nums = [2,0,2,1,1,0]
//          Output: [0,0,1,1,2,2]

//        Example 2:
//          Input: nums = [2,0,1]
//          Output: [0,1,2]
//
//        Constraints:
//          n == nums.length
//          1 <= n <= 300
//          nums[i] is either 0, 1, or 2.
//
//        Follow up: Could you come up with a one-pass algorithm using only constant extra space?
public class SortArrayOf_0_1_2 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0, j = 0, two = n-1;
        while(j <= two) {
            if(nums[j] == 2) {
                swap(nums, j, two);
                two--;
            } else if(nums[j] == 0) {
                swap(nums, zero, j);
                zero++;
                j++;
            } else {
                j++;
            }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
