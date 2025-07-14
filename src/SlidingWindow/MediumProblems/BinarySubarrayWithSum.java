package SlidingWindow.MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {
    public int numSubarraysWithSum_sol1(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum == goal) res++;
            if(map.containsKey(sum-goal)) {
                res += map.get(sum-goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    //------------------------------------------------------------------------------------------------------------
    public int numSubarraysWithSum_sol2(int[] nums, int goal) {
        if(goal == 0) return solve(nums);
        return atleast(nums, goal) - atleast(nums, goal+1);
    }
    private int atleast(int[] nums, int goal) {
        int i = 0, j = 0, n = nums.length;
        int sum = 0, res = 0;
        while(i < n) {
            while(j < n && sum < goal) {
                sum += nums[j];
                j++;
            }
            if(j == n && sum < goal) break;
            res += n-j+1;
            sum -= nums[i];
            i++;
        }
        return res;
    }
    private int solve(int[] nums) {
        int res = 0;
        int i = 0, j = 0, n = nums.length;
        while(j < n) {
            while(j < n && nums[j] == 0) j++;
            int width = j-i;
            res += (width * (width+1)/2);
            while(j < n && nums[j] == 1) j++;
            i=j;
        }
        return res;
    }
}
