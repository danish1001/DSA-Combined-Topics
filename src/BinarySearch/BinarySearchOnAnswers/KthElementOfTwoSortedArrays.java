package BinarySearch.BinarySearchOnAnswers;
//K-th element of two Arrays https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
//        Difficulty: MediumAccuracy: 37.4%Submissions: 335K+Points: 4Average Time: 15m
//        Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.
//
//        Examples :
//
//        Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
//        Output: 6
//        Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
//        Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
//        Output: 256
//        Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
//        Constraints:
//
//        1 <= a.size(), b.size() <= 106
//        1 <= k <= a.size() + b.size()
//        0 <= a[i], b[i] < 108
//        Expected Complexities
//        Time Complexity: O(log(min(a, b)))
//        Auxiliary Space: O(1)
public class KthElementOfTwoSortedArrays {

    // we are taking low as max(0, k-m)
    // because for e.g.
    // arr1 = [1,2,3,4,5] size = 5
    // arr2 = [6,7,8,9,10,11,12,13,14,15] size = 10
    // if k is 12 here
    // now if we took low as 0 then mid might appear at 1 or 2 then how we are going to get rest of elements from arr2
    // since arr2 size is 10, we must take few elements from arr1
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length;
        if(n > m) return kthElement(b, a, k);

        int low = Math.max(0, k-m);
        int high = Math.min(n, k);

        while(low <= high) {
            int mid1 = low + (high - low)/2;
            int mid2 = k-mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 > 0) l1 = a[mid1-1];
            if(mid1 < n) r1 = a[mid1];

            if(mid2 > 0) l2 = b[mid2-1];
            if(mid2 < m) r2 = b[mid2];


            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if(l2 > r1) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }

        return -1;
    }
}
