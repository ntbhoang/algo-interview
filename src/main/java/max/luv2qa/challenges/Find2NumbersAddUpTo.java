package max.luv2qa.challenges;

import max.luv2qa.sorting.QuickSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Find2NumbersAddUpTo {

    /*
        - arr = {1,21,3,14,5,60,7,6};
        - value = 81;
        - o/p: arr = {21,60};
     */
    public static void find2NumbersAddUpToN(int[] arr, int value, int size){

    }


    public static int[] bruteForce(int[] arr, int value, int size){
        // Sanity check
        if (size <= 1)
            System.out.println("Arr contains only 1 element!!! Cannot be check the sum.");
        int[] result = new int[2];
        // Outer loop is the number of times we need to repeat calculate sum of 2 numbers
        for (int i = 0; i < size; i++)
            // Inner loop is where we want to cal the sum
            for (int j = i + 1; j < size - 1; j++){
                int sum = arr[i] + arr[j + 1];
                if (sum == value){
                    result[0] = arr[i];
                    result[1] = arr[j + 1];
                }
            }
        return result;
    }

    static int[] mapSolution(int[] arr, int value, int size){
        int[] result = new int[2];
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < size; i++)
            map.put(value - arr[i], true);
        for (int i = 0; i < size; i++){
            if (map.containsKey(arr[i])){
                result[0] = arr[i];
                result[1] = value - arr[i];
            }
        }
        return result;
    }

    static boolean twoPointersSolution(int[] arr, int value){
        // Have to sort the array first
        QuickSort.quickSort(arr, 0, arr.length - 1);

        int left = 0, right = arr.length - 1;

        while (left < right){
            if (arr[left] + arr[right] == value)
                return true;
            // if sum < value, we have to increase the left index so the sum value will be increased
            else if (arr[left] + arr[right] < value)
                left += 1;
            else right -= 1;
        }
        return false;
    }


    static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 9, 10, 25};
        boolean res = twoPointersSolution(arr, 18);
        System.out.println(res);

    }
}
