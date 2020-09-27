package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Palindrome {
	
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		
		LinkedList<String> linkedList = new LinkedList<String>();		
		
		for(String item : aItems) {
			linkedList.add(item);
		}
		
		System.out.print(isPalindrome(linkedList));
		
	}
	
	static boolean isPalindrome(LinkedList<String> head) {
		LinkedList<String> reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}
	
	
	
	static LinkedList<String> reverseAndClone(LinkedList<String> list) {
		// 노드를 앞으로 추가한다.
		LinkedList<String> reversed = new LinkedList<String>();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			reversed.addFirst(iter.next());
		}
		return reversed;
	}
	static boolean isEqual(LinkedList<String> one, LinkedList<String> two) {		
		for(int i=0; i<one.size(); i++) {
			if(!one.get(i).equals(two.get(i))) {
				return false;
			}
		}		 
		return true;
	}

}
