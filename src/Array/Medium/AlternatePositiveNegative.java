package Array.Medium;

import java.util.List;

public class AlternatePositiveNegative {
    private void rearrange(List<Integer> arr) {
        int i = 0, n = arr.size();
        while(i < n) {
            if(i % 2 == 0) {
                // element must be positive
                // if not find the next positive
                if(arr.get(i) < 0) {
                    int endInd = i;
                    while(endInd < n && arr.get(endInd) < 0) endInd++;
                    if(endInd < n) rightRotate(arr, i, endInd);
                }
            } else {
                // element must be negative
                // if not find the next negative
                if(arr.get(i) >= 0) {
                    int endInd = i;
                    while(endInd < n && arr.get(endInd) >= 0) endInd++;
                    if(endInd < n) rightRotate(arr, i, endInd);
                }
            }
            i++;
        }
    }
    private void rightRotate(List<Integer> arr, int i, int j) {
        int temp = arr.get(j);
        for(int ind=j; ind>i; ind--) {
            arr.set(ind, arr.get(ind-1));
        }
        arr.set(i, temp);
    }
}
