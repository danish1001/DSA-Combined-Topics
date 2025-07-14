package BinarySearch.BinarySearchOn1DArray;

public class FloorCeil {
    public int findFloor(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;
        int floor = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= element) {
                floor = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public int findCeil(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;
        int ceil = high + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= element) {
                ceil = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }
}
