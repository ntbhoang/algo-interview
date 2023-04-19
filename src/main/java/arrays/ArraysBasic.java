package arrays;

import java.util.HashMap;
import java.util.Map;

public class ArraysBasic {


    static void merge2SortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++)
            mergedArr[i] = arr1[i];

        for (int i = arr1.length, j = 0; i < mergedArr.length  & j < arr2.length; i++, j++)
            mergedArr[i] = arr2[j];

        for (int i = 0; i < mergedArr.length; i++)
            System.out.println(mergedArr[i]);
    }


    static int findFirstUniqueNumber(int[] arr) {
        // Inside Inner Loop Check Each index of outerLoop If it's repeated in array
        //If it's not repeated then return this as first unique Integer
        boolean isRepeated = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    isRepeated = true;
                    break;
                }
            }
            if (isRepeated == false) return arr[i];
            else isRepeated = false;
        }
        return -1;
    }

    static int findUniqueNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], 0);
        }
        // Debug-1: After first map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("===========================================");

        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], map.get(arr[i]) + 1);
        // Debug-2: After 2nd map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("===========================================");


        // Key is the element of the array, and if the element has the value <=1
        for (int i = 0; i < arr.length; i++)
            if (map.get(arr[i]) == 1)
                return arr[i];
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 9, 5, 5, 5, 5, 1, 4, 3, 3, 3, 3};
        int[] arr2 = {2, 6, 7, 8};
        int[] arr3 = {9, 2, 3, 2, 6, 6};
        int[] arr4 = {4, 5, 1, 2, 0, 4};
        // merge2SortedArrays(arr1, arr2);
        System.out.println(findFirstUniqueNumber(arr1));
    }
}
