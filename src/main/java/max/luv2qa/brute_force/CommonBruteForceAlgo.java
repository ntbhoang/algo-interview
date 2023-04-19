package max.luv2qa.brute_force;

public class CommonBruteForceAlgo {

    /*
        - Time Complexity: O(n) because we're checking each element exactly once in the worst case.
     */

    public static int getMaxIndex(int[] arr){
        int maxIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[maxIndex] < arr[i])
                maxIndex = i;
        }
        return maxIndex;
    }

    /*
        - i++: runs n times
        - i < n: runs n + 1 times
        - i = 0: runs 1 times
        - Sum up: n + 1 + n + 1 = 2n + 2
        - Inside the loop, statements will run n times, let's say the constant of operations is c
        - So, it is: cn
        - Total T(n) = 2n + 2 + cn =
     */
    public static void justALoop(){
        int n = 10;
        for (int i = 0;  i < n; i++){
            // statement(s) that take constant time
        }

        /*
            - x += k: x gets incremented by k until it reaches n, so it is n/k
            - 1 + 1 + n/k + n/k = 2 + 2n/k
            - inside loop take c x n/k
            - T(n) = 2 + n(2+c)/k
         */
        int k = 2;
        for (int x = 0; x < n; x += k) {
            //statement(s) that take constant time
        }

        // Simple nested loop
        /*
            - inner loop: 2m + 2 + cm
            - outer loop run the inner loop n times
            - T(n) = n(2m + 2 + cm) + 2n + 2 = nm(2 + c) + 4n + 2
         */
        int m = 10;
        for (int i=0; i<n; i++){
            for (int j=0; j < m; j++){
                //Statement(s) that take(s) constant time
            }
        }

        /*
            - Nested for loop with dependent variables
            - T(n) = O(n2)
         */
        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                //Statement(s) that take(s) constant time
            }
        }

    }



}
