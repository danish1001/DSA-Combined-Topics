package Array.Hard;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithGivenXOR {
    public long subarrayXor(int arr[], int k) {
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        int xor = 0;

        for(int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
            if(xor == k) res++;
            if(map.containsKey(xor ^ k)) {
                res += map.get(xor ^ k);
            }
            map.put(xor, map.getOrDefault(xor, 0L) + 1L);
        }
        return res;
    }
}
