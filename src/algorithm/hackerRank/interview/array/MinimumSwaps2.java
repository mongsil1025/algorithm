package algorithm.hackerRank.interview.array;

import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps2 {
    // Complete the minimumSwaps function below.

    static int minimumSwaps(int[] arr) {

        int size = arr.length;
        int ordered  = 0;
        int swap = 0;
        while (size != ordered) {
            ordered = 0;
            for(int i=0; i<size; i++) {
                if(arr[i] != i + 1) {
                    int j = arr[i];

                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[i];
                    arr[i] = tmp;
                    swap++;
                } else {
                    ordered++;
                }
            }
        }
        return swap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(res);

        scanner.close();
    }    
}
