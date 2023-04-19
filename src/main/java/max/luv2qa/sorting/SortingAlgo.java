package max.luv2qa.sorting;

public class SortingAlgo {

    /*
        Selection sort algorithm
        The algorithm divides the input array into two parts: the sublist of already-sorted elements,
            which is built up from left to right, and the sublist of the remaining elements that occupy the
            rest of the list and need to be sorted.

        Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
        The algorithm proceeds by finding the smallest (or largest, depending on sorting order)
        element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element
         (putting it in sorted order), and moving the sublist boundaries one element to the right.

        In other words, this algorithm works by iterating over the array and swapping each element
        with the minimum element found in the rest of the array.

        T(n):  O(n2)  The quadratic time complexity makes it impractical for large inputs.
     */

    public static int[] selectionSort(int[] arr){
        int minIndex;
        for (int i = 0; i < arr.length; i++){
            // step-1: find the minVal
            minIndex = findMinIndex(arr, i, arr.length - 1);
            // step-2: swap the found minVal to the left most unsorted element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    /*
        - O(n2).
     */
    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1;  i++)
            for (int j = 0; j < arr.length - 1; j++)
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
        return arr;
    }


    /*
        insertionSort(array)
            mark first element as sorted
            for each unsorted element X
                'extract' the element X
                for j <- lastSortedIndex down to 0
                    if current element j > X
                        move sorted element to the right by 1
                    break loop and insert X here
            end insertionSort
     */
    public static int[] insertionSort(int[] arr){
        int unsortedElement, j;

        for (int step = 1; step < arr.length; step++){
            unsortedElement = arr[step];
            j = step - 1;  // arr[j] is the sorted element(s) on the leftmost sub-list, by default assume it is arr[0]

            // Compare unsortedElement with each element on the left of it until an element smaller than it is found
            // For descending order, change unsortedElement<array[j] to unsortedElement>array[j].
            while (j >= 0 && unsortedElement < arr[j]){
                arr[j + 1] = arr[j];
                j -= 1; // to break out of the loop
            }
            // Place unsortedElement at after the element just smaller than it.
            arr[j + 1] = unsortedElement;
        }
        return arr;
    }

    /*
        - Divide and control
     */

    public static void merge(int arr[], int left, int mid, int right){
        int i, j, k;

        // Initializing the sizes of the temporary arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Initializing temporary arrays
        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];

        // Copying the given array into the temporary arrays
        for (i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];
        for (j = 0; j < rightSize; j++)
            rightArr[j] = arr[mid + 1 + j];

        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray   // Merging the temporary arrays back into the given array
        k = left; // Initial index of the given array

        while (i < leftSize && j < rightSize){
            if (leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copying the remaining elements of leftArr[], if there are any
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArr[], if there are any
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int leftIndex, int rightIndex) {
        // Sanity checks
        if (leftIndex < 0 || rightIndex < 0)
            return;

        if (rightIndex > leftIndex) {
            // Equivalent to (leftIndex+rightIndex)/2, but avoids overflow
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            // Sorting the first and second halves of the array
            mergeSort(arr, leftIndex, mid);
            mergeSort(arr, mid + 1, rightIndex);

            // Merging the array
            merge(arr, leftIndex, mid, rightIndex);
        }
    }


    public static void quickSort(int arr[]){

    }

    public static int findMinIndex(int[] arr, int start, int end){
        if (end <= 0 || start < 0) return 0;

        int minIndex = start;
        for (int i = start + 1; i <= end; i++){
            if (arr[minIndex] > arr[i])
                minIndex = i;
        }

        return minIndex;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
