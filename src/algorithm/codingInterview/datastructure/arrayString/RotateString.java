package algorithm.codingInterview.datastructure.arrayString;

import java.util.Scanner;

public class RotateString {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String checkStr = scan.nextLine();
		scan.close();

		// 1. 문자열을 x와 y로 쪼개고, 체크 대상 str이 yx와 같은지 확인한다.
		for(int i=1; i<str.length() - 1; i++) {
			
			String x = str.substring(0, i);
			String y = str.substring(i, str.length());
			
			StringBuilder strBuilder = new StringBuilder(str.length());
			String rotated = strBuilder.append(y).append(x).toString();
			if(checkStr.equals(rotated)) {
				System.out.println("isSubstring!");
				break;
			}
			
		}
		
		// 2. x와 y를 쪼개는 지점에 관계없이 yx는 언제나 xyxy의 부분 문자열이다
		String s1s1 = str + str;
		if(s1s1.indexOf(checkStr) > 0) {
			System.out.println("isSubstring!");
		}
		
		
	}

}
