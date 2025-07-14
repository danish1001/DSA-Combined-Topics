package Array.Medium;

import java.util.ArrayList;

//2149. Rearrange Array Elements by Sign
//        You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//
//        You should return the array of nums such that the the array follows the given conditions:
//
//        Every consecutive pair of integers have opposite signs.
//        For all integers with the same sign, the order in which they were present in nums is preserved.
//        The rearranged array begins with a positive integer.
//        Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
//
//
//
//        Example 1:
//
//        Input: nums = [3,1,-2,-5,2,-4]
//        Output: [3,-2,1,-5,2,-4]
//        Explanation:
//        The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
//        The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
//        Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
//        Example 2:
//
//        Input: nums = [-1,1]
//        Output: [1,-1]
//        Explanation:
//        1 is the only positive integer and -1 the only negative integer in nums.
//        So nums is rearranged to [1,-1].
//
//
//        Constraints:
//
//        2 <= nums.length <= 2 * 105
//        nums.length is even
//        1 <= |nums[i]| <= 105
//        nums consists of equal number of positive and negative integers.
//
//
//        It is not required to do the modifications in-place.
public class RearrangeArrayAlternatingPositiveNegativeElements {
    public int[] rearrangeArray_sol1(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int pI = 0, nI = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] < 0) {
                neg[nI] = nums[i];
                nI++;
            } else {
                pos[pI] = nums[i];
                pI++;
            }
        }
        pI = nI = 0;
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                nums[i] = pos[pI];
                pI++;
            } else {
                nums[i] = neg[nI];
                nI++;
            }
        }
        return nums;
    }
    // --------------------------------------------------------------------------
    public int[] rearrangeArray_sol2(int[] nums) {
        int n = nums.length, neg = 0, pos = 0, i = 0;
        int[] res = new int[n];
        while(pos < n && nums[pos] < 0) {
            pos++;
        }
        while(neg < n && nums[neg] > 0) {
            neg++;
        }
        while(i < n && pos < n && neg < n) {
            // even
            if(i % 2 == 0) {
                res[i] = nums[pos];
                pos++;
            } else {
                res[i] = nums[neg];
                neg++;
            }
            i++;
            while(pos < n && nums[pos] < 0) {
                pos++;
            }
            while(neg < n && nums[neg] > 0) {
                neg++;
            }
        }
        while(i < n && pos < n) {
            res[i] = nums[pos];
            i++;
            pos++;
        }
        while(i < n && neg < n) {
            res[i] = nums[neg];
            i++;
            neg++;
        }
        return res;
    }

    // --------------------------------------------------------------------------
    // solution 3 In-Place
    public void rearrange_sol3(ArrayList<Integer> arr) {
        int i = 0, n = arr.size();
        while(i < n) {
            if(i % 2 == 0) {
                // must be positive
                if(arr.get(i) < 0) {
                    int nextPositiveInd = i;
                    while(nextPositiveInd < n && arr.get(nextPositiveInd) < 0) nextPositiveInd++;
                    if(nextPositiveInd < n) rightRotate(arr, i, nextPositiveInd);
                }
            } else {
                // must be negative
                if(arr.get(i) >= 0) {
                    int nextNegativeInd = i;
                    while(nextNegativeInd < n && arr.get(nextNegativeInd) >= 0) nextNegativeInd++;
                    if(nextNegativeInd < n) rightRotate(arr, i, nextNegativeInd);
                }
            }
            i++;
        }
    }
    private void rightRotate(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(j);
        while(i < j) {
            arr.set(j, arr.get(j-1));
            j--;
        }
        arr.set(i, temp);
    }

}
