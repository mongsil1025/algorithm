package algorithm.codingInterview.datastructure.arrayString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RotateMetrics {
	
	public static void main(String[] args) throws IOException {
		
		// int N = 4;
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[][] ary_img = new int[N][N];
		
		for(int i=0; i<N; i++) {
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			
			int j = 0;			
			for(String item : aItems) {				
				ary_img[i][j] = Integer.parseInt(item);
				j++;
			}

		}
		
//		int[][] ary_img = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int[][] result_img = rotate_nometrics(ary_img, N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(result_img[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] rotate(int[][] ary_img, int N) {
		
		int[][] ary_result = new int[N][N];
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				ary_result[x][y] = ary_img[N-1-y][x];
			}
		}
		
		return ary_result;
	}
	
	public static int[][] rotate_nometrics(int[][] ary_img, int N) {
		
		int tmp;
		for(int s=0, e=N-1; s<e; s++, e--) {
			for(int i=s, j=e; i<e; i++, j--) {
				tmp = ary_img[s][i];
				ary_img[s][i] = ary_img[j][s];
				ary_img[j][s] = ary_img[e][j];
				ary_img[e][j] = ary_img[i][e];
				ary_img[i][e] = tmp;
			}
		}
		
		return ary_img;
		
	}

}
