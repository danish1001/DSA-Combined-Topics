package Array.Hard;
//493. Reverse Pairs
//        Solved
//        Hard
//        Topics
//        Companies
//        Hint
//        Given an integer array nums, return the number of reverse pairs in the array.
//
//        A reverse pair is a pair (i, j) where:
//
//        0 <= i < j < nums.length and
//        nums[i] > 2 * nums[j].
//
//
//        Example 1:
//
//        Input: nums = [1,3,2,3,1]
//        Output: 2
//        Explanation: The reverse pairs are:
//        (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
//        (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
//        Example 2:
//
//        Input: nums = [2,4,3,5,1]
//        Output: 3
//        Explanation: The reverse pairs are:
//        (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
//        (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
//        (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
//
//
//        Constraints:
//
//        1 <= nums.length <= 5 * 104
//        -231 <= nums[i] <= 231 - 1
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] arr, int low, int high) {
        if(low >= high) return 0;
        int mid = low + (high - low)/2;
        int reversePairs = 0;
        reversePairs += mergeSort(arr, low, mid);
        reversePairs += mergeSort(arr, mid+1, high);
        reversePairs += countPairs(arr, low, mid, mid+1, high);
        merge(arr, low, mid, mid+1, high);
        return reversePairs;
    }
    private void merge(int[] arr, int low1, int high1, int low2, int high2) {
        int[] temp = new int[high2-low1+1];
        int ind = 0, i = low1, j = low2;
        while(i <= high1 && j <= high2) {
            if(arr[i] <= arr[j]) {
                temp[ind++] = arr[i++];
            } else {
                temp[ind++] = arr[j++];
            }
        }
        while(i <= high1) {
            temp[ind++] = arr[i++];
        }
        while(j <= high2) {
            temp[ind++] = arr[j++];
        }
        ind = 0;
        i = low1;
        while(i <= high2) {
            arr[i++] = temp[ind++];
        }
    }
    private int countPairs(int[] arr, int low1, int high1, int low2, int high2) {
        int i = low1, j = low2;
        int count = 0;
        while(i <= high1 && j <= high2) {
            if((long) arr[i] <= (long) 2 * (long) arr[j]) {
                i++;
            } else {
                count += high1-i+1;
                j++;
            }
        }
        return count;
    }
}
