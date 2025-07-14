package Array.Hard;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while(j < k && nums[j-1] == nums[j]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], i);
        }
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int sum = arr[i] + arr[j];
                if(map.containsKey(target - sum) && map.get(target - sum) > j) return true;
            }
        }
        return false;
    }
}
