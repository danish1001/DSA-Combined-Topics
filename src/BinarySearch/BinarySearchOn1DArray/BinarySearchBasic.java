package BinarySearch.BinarySearchOn1DArray;

public class BinarySearchBasic {
    public int binarySearch(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == element) {
                return mid;
            } else if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] arr, int element, int low, int high) {
        if(low > high) return -1;
        int mid = low + (high - low) / 2;

        if(arr[mid] == element) {
            return mid;
        } else if(arr[mid] < element) {
            return binarySearchRecursive(arr, element, mid + 1, high);
        } else {
            return binarySearchRecursive(arr, element, low, mid - 1);
        }
    }
}
