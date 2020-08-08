package algorithm.codingInterview.datastructure.arrayString;

import java.util.Scanner;


/* PSEUDO CODE
INIT
String originStr;
String compressedStr;
int count = 1 (자기 자신부터 시작);
BEGIN
READ	originStr;

FOR(0 to 문자열 originStr의 길이 - 1)
	IF(첫번째 char 와 두번째 char가 같다면) THEN
		hit count 증가;
	ELSE
		첫번째 char 와 hit count를 append 한다.
END FOR

EXEC 마지막 문자열을 처리하기 위해, 현재까지 캐시된 hit count 와 문자열의 마지막 char를 붙인다.

IF(compressedStr의 문자열 길이가 originStr의 문자열 길이보다 길다면) THEN
	return originStr;
ELSE
	return compressedStr;

-- 예외처리
EXCEPTION

	
END;

-- 시간복잡도 O(n) : 문자열의 길이만큼 LOOP가 진행된다.
*/

public class CompressString {
	
	public static void main(String[] args) {
		
		// 입력
		Scanner scan = new Scanner(System.in);
		
		String originStr = scan.nextLine();
		scan.close();
		
		String compressedStr = "";
		
		// 압축될 문자열의 길이를 먼저 구한다.
		// String을 Edit 하지 않으므로, 압축될 문자열이 원본보다 길다면 시간복잡도가 O(n)이 될 것 같다.
		int compressedLength = countCompresstion(originStr);
		
		if(compressedLength > originStr.length()) {
			System.out.println(originStr);
			System.exit(0); // 종료
		}
		
		StringBuilder compressed = new StringBuilder(compressedLength);
		compressedStr = compress(originStr, compressed);	
		
		System.out.println(compressedStr);

	}
	
	/**
	 * 미리 압축될 문자열의 길이를 구한다.
	 * @param str
	 * @return
	 */
	public static int countCompresstion(String str) {
		
		int compressedLength = 0;
		int hitCount = 1;
		
		for(int i=0; i<str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				hitCount ++;
			} else {
				compressedLength += 1 + String.valueOf(hitCount).length();				
				hitCount = 1;
			}
		}
		
		compressedLength += 1 + String.valueOf(hitCount).length();
		
		return compressedLength;
		
	}
	
	/**
	 * 문자열을 + 키로 붙이는 동작은 O(n^2) 시간이 걸린다.
	 * @param originStr
	 * @return
	 */
	public static String compressStringBad(String originStr) {
		
		int hitCount = 1;
		String compressedStr = "";

		for(int i=0; i<originStr.length() - 1; i++) {
			if(originStr.charAt(i) == originStr.charAt(i + 1)) {
				hitCount ++;
			} else {
				
				compressedStr += String.valueOf(originStr.charAt(i)) + String.valueOf(hitCount);
				
				hitCount = 1;
			}
		}
		
		compressedStr += String.valueOf(originStr.charAt(originStr.length() - 1)) + String.valueOf(hitCount);
		
		if(compressedStr.length() > originStr.length()) {
			return originStr;
		} else {
			return compressedStr;
		}
		
	}
	
	/**
	 * StringBulder를 이용하면 단순하게 가변 크기 배열을 이용해서 필요한 경우에만 문자열을 복사하게끔 해준다.
	 * @param originStr
	 * @param compressed
	 * @return
	 */
	public static String compress(String originStr, StringBuilder compressed) {
		
		int hitCount = 1;

		for(int i=0; i<originStr.length() - 1; i++) {
			if(originStr.charAt(i) == originStr.charAt(i + 1)) {
				hitCount ++;
			} else {
				
				compressed.append(originStr.charAt(i));
				compressed.append(hitCount);
				
				hitCount = 1;
			}
		}
		
		compressed.append(originStr.charAt(originStr.length() - 1));
		compressed.append(hitCount);
		
		if(compressed.length() > originStr.length()) {
			return originStr;
		} else {
			return compressed.toString();
		}
	}

}
