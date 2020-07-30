package algorithm.codingInterview.datastructure.arrayString;

import java.util.Scanner;

public class PalindromePermutation {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		System.out.println(isPermutationOfPalindromeBitVector(str) ? "Yes, It's Permutation of Palindrome" : "No, It's not Permutation of Palindrome");
		
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	/**
	 * 홀수 문자가 한 개 이상 존재하는지 확인한다.
	 * @param table
	 * @return
	 */
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for(int count : table) {
			if(count % 2 == 1) {
				if(foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	/**
	 * 각 문자에 숫자를 대응시킨다.
	 * 대소문자 구분이 없고, 문자가 아닌 경우에는 -1로 대응시킨다.
	 * @param c
	 * @return
	 */
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a<=val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	/**
	 * 각 문자가 몇 번 등장했는지 센다.
	 * @param phrase
	 * @return
	 */
	public static int[] buildCharFrequencyTable(String phrase) {
		
		// 문자 체크 배열 생성
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x] ++;
			}
		}
		
		return table;
		
	}
	
	/**************************
	 * 비트 벡터를 이용하는 해법
	 */
	
	public static boolean isPermutationOfPalindromeBitVector(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	/**
	 * 모든 문자열의 문자를 비트벡터로 만들어준다.
	 */
	public static int createBitVector(String phrase) {
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x); // 모든 문자열의 문자를 비트벡터로 만들어준다.
		}
		return bitVector;
	}
	
	/**
	 * 등장한 문자의 비트를 바꿔준다.
	 */
	public static int toggle(int bitVector, int index) {
		if(index < 0) return bitVector;
		int mask = 1 << index; // 문자 c의 int 숫자만큼 left shift한다. 00001000000
		if((bitVector & mask) == 0) { // 여태까지 등장한 문자가 아니라면
			bitVector |= mask; // 더해준다.			
		} else {
			bitVector &= ~mask; // 등장했던 문자라면 다시 0으로 만들어 준다.
		}
		return bitVector;
	}
	
	/**
	 * 정확히 비트 한 개만 1로 세팅 됐는지 확인하기 위해 주어진 정수값에서 1을 뺀 뒤
	 * 원래 값과 AND연산을 한다.
	 */
	public static boolean checkExactlyOneBitSet(int bitVector) {
		// 오직 하나의 비트만 1일 경우에, 1을 빼고 원본숫자를 &연산하면 0이된다.
		return (bitVector & (bitVector - 1)) == 0;
	}

}
