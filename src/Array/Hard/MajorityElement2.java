package Array.Hard;

import java.util.ArrayList;
import java.util.List;

//229. Majority Element II https://leetcode.com/problems/majority-element-ii/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        Hint
//        Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//        Example 1:
//
//        Input: nums = [3,2,3]
//        Output: [3]
//        Example 2:
//
//        Input: nums = [1]
//        Output: [1]
//        Example 3:
//
//        Input: nums = [1,2]
//        Output: [1,2]
//
//
//        Constraints:
//
//        1 <= nums.length <= 5 * 104
//        -109 <= nums[i] <= 109
//
//
//        Follow up: Could you solve the problem in linear time and in O(1) space?

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0;
        int p1 = 0, p2 = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(c1 == 0 && p2 != nums[i]) {
                p1 = nums[i];
                c1++;
            } else if(c2 == 0 && p1 != nums[i]) {
                p2 = nums[i];
                c2++;
            } else if(p1 == nums[i]) {
                c1++;
            } else if(p2 == nums[i]) {
                c2++;
            } else {
                c1--;
                c2--;
                if(c1 < 0) c1 = 0;
                if(c2 < 0) c2 = 0;
            }
        }
        List<Integer> res = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == p1) c1++;
            if(nums[i] == p2) c2++;
        }
        if(p1 == p2 && c1 > n/3) {
            res.add(p1);
            return res;
        }
        if(c1 > n/3) res.add(p1);
        if(c2 > n/3) res.add(p2);
        return res;
    }
}
