package algorithm.codeup.recursive;

import java.util.Scanner;

public class Recursive1 {
	
	public static void main(String args[]) {
		
		Scanner sc = new java.util.Scanner(System.in);
		int n = sc.nextInt();
		
//		printNum(n+1);
		
		printNumReverse(n);
		
	}
	
	public static int printNum(int n) {
		
		if(n < 0) {
			return 0;
		}
		
		int result = printNum(n-1);
		
		if(result > 0) {
			System.out.println(result);
		}		
		
		return n;
		
	}
	
	public static int printNumReverse(int n) {
		
		if(n > 0) {
			System.out.println(n);
		}		
		
		if(n == 0) {
			return 0;
		}
		
		int result = printNumReverse(n-1);
		
		return result;
		
	}

}
