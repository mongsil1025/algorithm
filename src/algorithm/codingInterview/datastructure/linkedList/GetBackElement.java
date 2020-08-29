package algorithm.codingInterview.datastructure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class GetBackElement {
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		
		LinkedList linkedList = new LinkedList();
		
		for(String item : aItems) {				
			linkedList.append(Integer.parseInt(item));
		}
		
		int k = 3;
//		int answer = getBackElement(linkedList, k);
//		System.out.println("answer : " + answer);	
		
//		recursiveGetBackElement(linkedList.header, k, 0);
		
//		Reference idx = new Reference();
//		Node found = recursiveGetBackElement(linkedList.header, 3, idx);
		
		Node found = repeatGetBackElement(linkedList, 3);
		System.out.print(found.data);
		
//		runnerGetBackElement(linkedList, k);
		
	}
	
	public static int getBackElement(LinkedList list, int k) {
		
		List<Integer> aryList = new ArrayList<>();
		
		Node n = list.header;
		
		while(n.next != null) {			
			aryList.add(n.data);
			n = n.next;
		}		
		aryList.add(n.data);
		
		return aryList.get(aryList.size() - k);
	}
	
	public static int[] recursiveGetBackElement(Node n, int k, int tot) {

		int[] result = new int[2];
		
		int curIndex = tot;
				
		if(n.next == null) {
			result[0] = -1;
			result[1] = tot;
			return result; // 재귀 종료
		} else {
			tot ++; // 링크드리스트 원소 사이즈
		}
		
		result = recursiveGetBackElement(n.next, k, tot); // 재귀호출
		
		if(curIndex == result[1] - k + 1) {
			System.out.print(n.data);
		}
		
		return result;
	
	}
	
	public static int recursiveGetBackElement2(Node n, int k) {
				
		if(n.next == null) {
			return 0;
		}
		
		int counter = recursiveGetBackElement2(n.next, k) + 1;
		
		if(counter == k) {
			System.out.print(n.data);
		}
		
		return counter;
	
	}
	
	static class Reference {
		public int count = 0;
	}
	
	public static Node recursiveGetBackElement(Node n, int k, Reference r) {
		if(n == null) {
			return null;
		}
		
		Node found = recursiveGetBackElement(n.next, k, r);
		
		r.count = r.count + 1;
		if(r.count == k) {
			return n;
		}
		
		return found;
	}
	
	public static void runnerGetBackElement(LinkedList list, int k) {
		
		Node n = list.header;
		Node r = n;
		
		int tot = 0;
		while(n.next != null) {
			n = n.next;
			tot ++;
		}
		tot ++;
		
		for (int i=0; i < tot - k; i++) {
			r = r.next;
		}
		
		System.out.print(r.data);
		
	}
	
	public static Node repeatGetBackElement(LinkedList list, int k) {
		
		Node p1 = list.header;
		Node p2 = list.header;
		
		for(int i=0; i<k; i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
		
		
	}


}
