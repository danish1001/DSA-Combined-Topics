package Array.Hard;
//Count Inversions
//        Difficulty: MediumAccuracy: 16.93%Submissions: 653K+Points: 4
//        Given an array of integers arr[]. Find the Inversion Count in the array.
//        Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
//
//        Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
//        If an array is sorted in the reverse order then the inversion count is the maximum.
//
//        Examples:
//
//        Input: arr[] = [2, 4, 1, 3, 5]
//        Output: 3
//        Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
//        Input: arr[] = [2, 3, 4, 5, 6]
//        Output: 0
//        Explanation: As the sequence is already sorted so there is no inversion count.
//        Input: arr[] = [10, 10, 10]
//        Output: 0
//        Explanation: As all the elements of array are same, so there is no inversion count.
//        Constraints:
//        1 ≤ arr.size() ≤ 105
//        1 ≤ arr[i] ≤ 104
public class CountInversions {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }
    private static int mergeSort(int[] arr, int low, int high) {
        int inversionCount = 0;
        if(low >= high) return inversionCount;

        int mid = low + (high - low) / 2;
        inversionCount += mergeSort(arr, low, mid);
        inversionCount += mergeSort(arr, mid+1, high);
        inversionCount += merge(arr, low, mid, mid+1, high);
        return inversionCount;
    }
    private static int merge(int[] arr, int low1, int high1, int low2, int high2) {
        int[] temp = new int[high2-low1+1];
        int count = 0;
        int ind = 0, i = low1, j = low2, n = high1, m = high2;

        while(i <= n && j <= m) {
            if(arr[i] <= arr[j]) {
                temp[ind] = arr[i];
                i++;
            } else {
                temp[ind] = arr[j];
                count += high1-i+1;
                j++;
            }
            ind++;
        }
        while(i <= n) temp[ind++] = arr[i++];
        while(j <= m) temp[ind++] = arr[j++];

        for(i=low1; i<=high2; i++) {
            arr[i] = temp[i-low1];
        }

        return count;
    }
}
