package algorithm.codingInterview.datastructure;

public class ArrayString {

	/**************
	 * 
	 * 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘을 작성하라.
	 * 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라. 
	 * 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		String str = "aksldfwerq";
		System.out.println(isUniqueChars2(str) == true ? "Yes It's unique String" : "No it has duplicated character");
		
	}
	
	/**
	 * 가독성 높은 코드
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		if(str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false; // 중복
			}
			char_set[val] = true;
		}
		return true;
	}
	
	/**
	 * 비트연산자를 이용한 메모리 최소화
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars2(String str) {
		int checker = 0;
		for (int i=0; i<str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
			
		}
		return true;
	}
	
}
