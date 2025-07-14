package SlidingWindow.MediumProblems;
import java.util.HashMap;
import java.util.Map;
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays_sol1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) count++;
            if(count == k) res++;
            if(map.containsKey(count-k)) {
                res += map.get(count-k);
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return res;
    }
    //---------------------------------------------------------------------------------------------------------
    public int numberOfSubarrays_sol2(int[] nums, int k) {
        return atLeastOdd(nums, k) - atLeastOdd(nums, k+1);
    }
    private int atLeastOdd(int[] nums, int k) {
        int i=0, j=0, n=nums.length;
        int oddCount = 0;
        int res = 0;

        while(i < n) {
            while(j < n && oddCount < k) {
                if(nums[j] % 2 == 1) oddCount++;
                j++;
            }
            if(j == n && oddCount < k) break;
            res += n - j + 1;
            if(nums[i] % 2 == 1) oddCount--;
            i++;
        }
        return res;
    }
}
