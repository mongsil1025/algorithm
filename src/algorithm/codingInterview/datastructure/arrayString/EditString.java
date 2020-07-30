package algorithm.codingInterview.datastructure.arrayString;

import java.util.Scanner;

public class EditString {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String a = scan.nextLine();
		String b = scan.nextLine();
		
		scan.close();
		
		// System.out.println(canMakeSameString(a,b) ? "Can Make Same String Once" : "No couldnt");
		System.out.println(oneEditAway2(a,b) ? "Can Make Same String Once" : "No couldnt");
		
	}
	
	/**
	 * 단 한번의 편집으로 동일한 문자열을 만들 수 있는지에 대한 체크
	 */
	public static boolean canMakeSameString(String a, String b) {
		
		// (1) 문자열의 길이가 같지 않거나, 두 문자열의 차이가 1이 아닐 경우에는 가능성도 없으니 return false
		if(!(a.length() == b.length() || (a.length() - b.length()) == 1 || (a.length() - b.length()) != 1)) {
			return false;
		}
		
		// (2) 짧은 문자열의 length()만큼 긴 문자열이 중복되는지 확인한다.
		int checkCnt = 0;
		if(a.length() == b.length()) {
			checkCnt = a.length() - 1;
		} else if(a.length() < b.length()) {
			checkCnt = a.length();
		} else if(a.length() > b.length()) {
			checkCnt = b.length();
		}
		
		// 두 문자열의 등장 횟수를 해시 테이블로 만든다.
		int[] hashTable = buildCharFrequencyTable(a, b);
		
		// 체크
		int cnt = 0;
		
		for(int n : hashTable) {
			if(n > 1) {
				cnt++;
			}
		}
		
		if(checkCnt != cnt) {
			return false;
		}
		
		return true;
		
	}
	
	// char c를 int 로 만든다.
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a<=val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	// 문자열 a, b의 등장 횟수를 적재한다.
	public static int[] buildCharFrequencyTable(String a, String b) {
		
		// 문자 체크 배열 생성
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for(char c : a.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x] ++;
			}
		}
		
		for(char c : b.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x] ++;
			}
		}
		
		return table;
		
	}
	
	///////////////////////////////////////
	// 책에 있는 해법 (1)
	///////////////////////////////////////
	public static boolean oneEditAway(String first, String second) {
		if(first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if(first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if(first.length() - 1 == second.length()) {
			return oneEditAway(second, first);
		}
		return true;
	}
	
	// 두 문자열이 동일할때
	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundDifference) { // 중복된게 이미 하나가 있었다면
					return false;
				}
				foundDifference = true;
			}
		}
		return false;
	}
	
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		
		while(index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1 != index2) { // 또 다른 문자열을 발견했을 때, 서로의 index가 다르다면 (이미 다른게 있었다는 의미)
					return false;
				}
				index2 ++; // 긴문자열의 index를 증가
			} else { // 같으면 통과
				index1 ++;
				index2 ++;				
			}
		}
		
		return true;
	}
	
	///////////////////////////////////////
	// 책에 있는 해법 (2)
	///////////////////////////////////////
	public static boolean oneEditAway2(String first, String second) {

		// 길이 체크
		// Math.abs : 절대값 Return
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		// 길이가 짧은 문자열과 긴 문자열 찾기
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) { // 문자가 다르다면				
				if(s1.length() == s2.length()) {
					if(foundDifference) { // 이미 다른걸 찾았었다면
						return false;
					}
					foundDifference = true;
				} else {
					index2 ++;
				}
			} else {
				index1 ++;
				index2 ++;
			}
			
		}
		
		return true;
		
	}

}
