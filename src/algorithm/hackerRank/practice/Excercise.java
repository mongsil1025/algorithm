package algorithm.hackerRank.practice;
import java.util.Scanner;

public class Excercise {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int x = 0;
        int y = 0;
        
        int max = -45;
        while (y < 4) {
        	while (x < 4) {
        		
        		int sum = 0;
        		for(int i=0; i<3; i++) {
        			for(int j=0; j<3; j++) {
        				
        				if(i == 1) {
        					sum += arr[i+y][1+x];
        					break;
        				} else {
        					sum += arr[i+y][j+x];
        				}
        				
        			}
        		}

        		if(sum > max) {
        			max = sum;
        		}
        		
        		x ++;
        	}
        	y++;
        	x = 0;
        }
        
        System.out.print(max);

        scanner.close();
    }
}


