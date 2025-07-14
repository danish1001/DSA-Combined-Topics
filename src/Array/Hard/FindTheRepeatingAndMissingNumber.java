package Array.Hard;

import java.util.ArrayList;

//Missing And Repeating
//        Difficulty: EasyAccuracy: 24.83%Submissions: 586K+Points: 2Average Time: 30m
//        Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing and one number b occurs twice in the array. Find numbers a and b.
//
//        Note: The test cases are generated such that there always exists one missing and one repeating number within the range [1,n].
//
//        Examples:
//
//        Input: arr[] = [2, 2]
//        Output: [2, 1]
//        Explanation: Repeating number is 2 and smallest positive missing number is 1.
//        Input: arr[] = [1, 3, 3]
//        Output: [3, 2]
//        Explanation: Repeating number is 3 and smallest positive missing number is 2.
//        Input: arr[] = [4, 3, 6, 2, 1, 1]
//        Output: [1, 5]
//        Explanation: Repeating number is 1 and the missing number is 5.
//        Constraints:
//        2 ≤ arr.size() ≤ 106
//        1 ≤ arr[i] ≤ arr.size()
public class FindTheRepeatingAndMissingNumber {
    ArrayList<Integer> findTwoElement_sol1(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0, n=arr.length;
        int missing = -1, repeating = -1;
        while(i < n) {
            if(arr[i] == i+1) {
                i++;
            } else {
                if(arr[i] == arr[arr[i]-1]) {
                    missing = i+1;
                    repeating = arr[i];
                    i++;
                } else {
                    swap(arr, i, arr[i]-1);
                }
            }
        }
        res.add(repeating);
        res.add(missing);
        return res;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //--------------------------------------------------------------------------------
    int[] findTwoElement_sol2(int arr[]) {
        int n = arr.length, repeating = -1, missing = -1;
        int[] map = new int[n+1];
        for(int i=0; i<n; i++) map[arr[i]]++;

        for(int i=1; i<=n; i++) {
            if(map[i] == 2) repeating = i;
            if(map[i] == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }
}
