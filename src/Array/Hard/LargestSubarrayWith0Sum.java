package Array.Hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWith0Sum {
    public int maxLenSubArrayWith0Sum(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(sum == 0) {
                res = Math.max(res, i+1);
            }
            if(map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
