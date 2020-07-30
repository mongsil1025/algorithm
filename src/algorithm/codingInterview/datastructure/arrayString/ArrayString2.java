package algorithm.codingInterview.datastructure.arrayString;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayString2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String a = scan.nextLine();
		String b = scan.nextLine();
		
		System.out.println(a + ":" + b);
		
		scan.close();
		
		System.out.println(permutation2(a,b) ? "Is Permutation" : "Not Permutation");
		
	}
	
	/**
	 * 풀이 #1 : 정렬하라
	 * @param s
	 * @return
	 */
	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean permutation(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	/**
	 * 풀이 #2 : 문자열에 포함된 문자의 출현 횟수가 같은지 검사하라
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean permutation2(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128];
		char[] s_array = s.toCharArray();
		for(char c : s_array) {
			letters[c] ++;
		}
		
		for(int i=0; i<t.length(); i++) {
			int c = t.charAt(i);
			letters[c] --;
			if(letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
	
}
