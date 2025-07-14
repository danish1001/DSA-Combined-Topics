package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n-3; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1; j<n-2; j++) {
                if(j > i+1 && nums[j-1] == nums[j]) continue;
                int k = j+1;
                int l = n-1;
                while(k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if(sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;
                        l--;
                        while(k < l && nums[k-1] == nums[k]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    } else if(sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
