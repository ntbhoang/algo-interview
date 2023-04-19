package max.luv2qa.sorting;

import java.util.Random;

public class QuickSort {

    public static int choosePivot(int left, int right){
        Random rand = new Random();
        // Pick up 3 random numbers with the range of the array
        int number1 = left + (rand.nextInt(right - left + 1));
        int number2 = left + (rand.nextInt(right - left + 1));
        int number3 = left + (rand.nextInt(right - left + 1));

        // Return their median
        return Math.max(Math.min(number1, number2), Math.min(Math.max(number1, number2), number3));
    }

    public static int partition(int arr[], int left, int right){
        // The random method and the swap helps to pick the best pivot number than move it to the first index
        int pivotIndex = choosePivot(left, right);

        swap(arr, left, pivotIndex);
        int pivotNumber = arr[right];
        int i = (left - 1); // All elements less than or equal to the pivot go before or at i

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivotNumber) {
                i++; // increment the index
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); // Putting the pivot back in place
        return (i + 1);
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            // pi is where the pivot is at
            int pi = partition(arr, left, right);

            // Separately sort elements before and after partition
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }


    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int pivot = choosePivot(1, 10);
        System.out.println(pivot);
    }


}

/*
    Quick sort algorithm:
    1- Start with an array of n elements.
    2- Choose a pivot element from the array to be sorted.
    3- Partition the array into two unsorted subarrays, such that all elements in one subarray are less than the
        pivot and all the elements in the other subarray are greater than the pivot.
    4- Elements that are equal to the pivot can go in either subarray.
    5- Sort each subarray recursively to yield two sorted subarrays.
    Concatenate the two sorted subarrays and the pivot to yield one sorted array.
    Note that if we always pick the smallest element in the array as the pivot, the left-hand side array is always empty, and all the remaining items end up in the right-hand side array. This means that the array will be subdivided a total of O(n)
O(n)
 times. Since the partitioning takes O(n)
O(n)
 time for each divide step., this has a total time complexity of O(n^2)
O(n
2
 )
. This is the worst-case time complexity for Quicksort because the depth of recursion is maximum.
 */
