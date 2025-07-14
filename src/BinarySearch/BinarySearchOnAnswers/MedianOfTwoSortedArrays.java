package BinarySearch.BinarySearchOnAnswers;
//4. Median of Two Sorted Arrays https://leetcode.com/problems/median-of-two-sorted-arrays/description/
//        Solved
//        Hard
//        Topics
//        Companies
//        Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//        The overall run time complexity should be O(log (m+n)).
//
//
//
//        Example 1:
//
//        Input: nums1 = [1,3], nums2 = [2]
//        Output: 2.00000
//        Explanation: merged array = [1,2,3] and median is 2.
//        Example 2:
//
//        Input: nums1 = [1,2], nums2 = [3,4]
//        Output: 2.50000
//        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
//        Constraints:
//
//        nums1.length == m
//        nums2.length == n
//        0 <= m <= 1000
//        0 <= n <= 1000
//        1 <= m + n <= 2000
//        -106 <= nums1[i], nums2[i] <= 106
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays_sol1(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n > m) return findMedianSortedArrays_sol1(nums2, nums1);

        int low = 0, high = n;
        int size = n+m;

        while(low <= high) {
            int mid1 = low + (high - low)/2;
            int mid2 = ((size+1)/2) - mid1;

            int l1 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 > 0) l1 = nums1[mid1 - 1];
            if(mid1 < n) r1 = nums1[mid1];
            if(mid2 > 0) l2 = nums2[mid2 - 1];
            if(mid2 < m) r2 = nums2[mid2];

            if(l1 <= r2 && l2 <= r1) {
                if(size % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / (double) 2;
                }
                return Math.max(l1, l2);
            } else if(l2 > r1) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }
        return (double) -1;
    }

    public double findMedianSortedArrays_sol2(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n/2+1];

        int i=0, j=0, k=0;

        while(i<nums1.length && j<nums2.length && k<(n/2)+1) {
            if(nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while(i<nums1.length && k<(n/2)+1) {
            arr[k++] = nums1[i++];
        }
        while(j<nums2.length && k<(n/2)+1) {
            arr[k++] = nums2[j++];
        }
        if(n%2 == 0) {
            return (double) (arr[n/2-1] + arr[n/2])/2;
        } else {
            return (double) arr[n/2];
        }
    }
}
