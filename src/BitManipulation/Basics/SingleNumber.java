package BitManipulation.Basics;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber_sol1(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
    public int singleNumber_sol2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            if(m.getValue() == 1) {
                return m.getKey();
            }
        }
        return res;
    }
}
