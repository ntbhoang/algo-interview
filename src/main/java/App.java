import max.luv2code.data_structure_p1.Queue;
import max.luv2code.data_structure_p1.SimpleQueue;
import max.luv2code.data_structure_p1.Stack;

import java.util.Objects;

public class App {

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1};
        int j = arr.length - 1;

        for (int i = 0; i <= arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            j--;
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);


        System.out.println(isPal("Hoang"));
        System.out.println(isPal("AnnA"));
        System.out.println(isPal("Max"));
        System.out.println(isPal("123321"));

    }

    static String reverseString(String aString) {
        String reverseString = "";

        char[] stringChars = aString.toCharArray();
        for (int i = stringChars.length - 1; i >= 0; i--) {
            reverseString += stringChars[i];
        }
        return reverseString;
    }

    static boolean isPal(String aString) {
        String reversedString = reverseString(aString);
        if (Objects.equals(reversedString, aString)) return true;
        else return false;
    }

    static boolean isPal2Pointers(String aString) {
        int tailIndex = aString.length() - 1;

        for (int headIndex = 0; headIndex <= aString.length() / 2; headIndex++)
            if (aString.charAt(headIndex) != aString.charAt(tailIndex - headIndex))
                return false;

        return true;
    }
    static void sort(int[] arr) {

    }

    static int findMaxNumIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = 0; i < end; i++)
            if (arr[maxIndex] < arr[i])
                maxIndex = i;

        return maxIndex;
    }
}



