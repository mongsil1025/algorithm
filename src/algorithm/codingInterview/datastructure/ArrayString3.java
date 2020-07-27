package algorithm.codingInterview.datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayString3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] strAry = Arrays.copyOf(str.toCharArray(), 128);
		System.out.println(replaceSpaces(strAry, str.length()));
		System.out.println(replaceSpaces(str));
		sc.close();
	
	}
	
	/**
	 * Char Array 사용
	 * @param str
	 * @param trueLength
	 * @return
	 */
	public static char[] replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		// Count space number
		for(i=0; i<trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		// Edit char Array
		index = trueLength + spaceCount * 2;
		str[trueLength] = '\0'; // 배열의 끝
		for(i = trueLength - 1; i>= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index --;
			}
		}
		return str;
	}
	
	/**
	 * String 사용
	 * @param str
	 * @return
	 */
	public static String replaceSpaces(String str) {		
		return str.replace(" ", "%20"); 
	}

}
