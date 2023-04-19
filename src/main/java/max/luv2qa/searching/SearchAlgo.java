package max.luv2qa.searching;

public class SearchAlgo {

    // Linear search
    public static int linearSearch(int[] arr, int size, int s) {
        // Sanity check
        if (size <= 0) return -1;

        for (int i = 0; i < size; i++) {
            if (arr[i] == s)
                return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch1(int[] arr, int size, int s){
        int start = 0;
        int end = size - 1;
        int mid;

        if (size <= 0)
            return -1;

        // If the array only contains one element or none
        if (size == 1){
            if (arr[0] == s)
                return 0;
            else
                return -1;
        }

        while (start <= end){
            mid = (end + start) / 2;
            // If the element at the middle is smaller than the element we're searching for
            // the element we're searching for is in the later half of the array -> start = mid + 1
            if (arr[mid] < s)
                start = mid + 1;
            // If the element at the middle is greater than the  element we're searching for
            // The element is in the initial half of the array, hence the end index -1
            else if (arr[mid] > s)
                end = mid - 1;
            else
                return mid;
        }
        // If the value we're searching for is not on the array
        return -1;
    }

    static int binarySearch(int array[], int x, int low, int high) {

        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If found at mid, then return it
            if (array[mid] == x)
                return mid;

            // Search the left half
            if (array[mid] > x)
                return binarySearch(array, x, low, mid - 1);

            // Search the right half
            return binarySearch(array, x, mid + 1, high);
        }

        return -1;
    }


    public static void main(String[] args) {
        // Sanity check
        int[] arr = {1, -3, 0, 55, 3};
        int res = binarySearch(arr, 1, 0, arr.length - 1);
        System.out.println(res);

    }
}
