package BinarySearch.BinarySearchOn1DArray;

public class BitonicArray {
    public int maxElementInBitonicArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(mid > 0 && mid < n-1) {
                if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                    return arr[mid];
                } else if(arr[mid-1] < arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if(mid == n-1) {
                return arr[mid];
            } else if(mid == 0) {
                return Math.max(arr[mid], arr[mid+1]);
            }
        }

        return -1;
    }
}
