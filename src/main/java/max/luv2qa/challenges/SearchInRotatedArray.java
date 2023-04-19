package max.luv2qa.challenges;

public class SearchInRotatedArray {
    /*
        - Problem statement:
            Given a sorted array of n integers that has been rotated an unknown number of times,
            write code to find an element in the array.
            You may assume that the array was originally sorted in ascending order.
         - Input: A sorted array that has been rotated a number of times
         - O/P:
            - int arr[] = {7, 8, 9, 0, 3, 5, 6}
            - int left = 0  // starting index of the arr
            - int right = 6 // ending index of the arr
            - int n = 3 // search key
            - o/p: 4 - where the key is found

     */
    
    static int binarySearchRecursive(int arr[], int left, int right, int searchValue){
        int mid;

        if (right >= left){
            mid = (left + right) / 2;

            // If found at mid, return it
            if (arr[mid] == searchValue)
                return mid;

            // Search the left half
            if (arr[mid] > searchValue)
                return binarySearchRecursive(arr, left, mid - 1, searchValue);

            return binarySearchRecursive(arr, mid + 1, right, searchValue);
        }
        return -1;
    }

    static int binarySearch(int arr[], int left, int right, int searchValue){
        int mid;

        while (right >= left) {
            mid = (left + right) / 2;

            if (arr[mid] == searchValue)
                return mid;

            // shift the right to the position mid - 1 which is belonged to the left sub-array
            if (arr[mid] > searchValue)
                right = mid - 1;

            // shift the left to the position of mid + 1 which belonged to the right sub-array
            else
                left = mid + 1;
        }

        return -1;
    }

    static int partition(int[] arr, int low, int high){
        // Choose the rightmost element as the pivot
        int pivot = arr[high];

        // Second pointer, point to the greater element
        int i = low - 1;

        // Traverse through elements, compare each ele with pivot
        for (int j = low; j < high; j++){
            if (arr[j] <= pivot) {
                // If ele smaller than pivot is - found
                // swap it with the  greater ele pointed by i
                i++;

                // swapping element at i with element at j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // After sorting elements that smaller than pivot, swap the pivot to the
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
}


    public static void main(String[] args) {
        int arr[] = { 11, 89, 9, -10, 8 };
        quickSort(arr, 0, arr.length - 1);
        int res = binarySearch(arr, 0, arr.length - 1, 9);
        System.out.println(res);
        //Helper.printArray(arr);

    }
}
