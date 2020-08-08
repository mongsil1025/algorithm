package algorithm.codingInterview.datastructure.arrayString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ZeroMetrics {
	
	public static void main (String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		int[][] ary = new int[M][N];
		
		// INPUT
		for(int i=0; i<M; i++) {
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			
			int j = 0;			
			for(String item : aItems) {				
				ary[i][j] = Integer.parseInt(item);
				j++;
			}

		}
		
		// EXECUTE
		int[][] result = zeroAry(ary, M, N);
		
		// PRINT
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 0을 담아둘 저장공간 MxN O(n^)
	 * 
	 */
	public static int[][] zeroAry(int[][] ary, int m, int n) {
		
		// O(N^)
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(ary[i][j] == 0) {
					ary[i][j] = -1;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(ary[i][j] == -1) {
					
					for(int t=0; t < m; t++) {
						ary[t][j] = 0;
					}
					
					for(int t=0; t < n; t++) {
						ary[i][t] = 0;
					}
					
					break;
					
				}				
				
			}
		}
		
		return ary;
	}
	
	/**
	 * 0을 담아둘 저장공간 O(n)
	 * 
	 */
	public static int[][] zeroAry2(int[][] ary, int m, int n) {
		
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];
		
		// O(N^)
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(ary[i][j] == 0) {
					row[i] 		= true;
					column[j] 	= true;
				}
			}
		}
		
		// 행의 원소를 전부 0으로 바꾼다.
		for(int i=0; i<row.length; i++) {
			if(row[i]) {
				for(int j=0; j<m; j++) {
					ary[i][j] = 0;
				}
			}
		}
		
		// 열의 원소를 전부 0으로 바꾼다.
		for(int i=0; i<column.length; i++) {
			if(column[i]) {
				for(int j=0; j<n; j++) {
					ary[j][i] = 0;
				}
			}
		}
		
		return ary;
	}

}
