package algorithm.codingInterview.datastructure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;


public class Intersection {
	
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		
		LinkedList l1 = new LinkedList();
		
		int[] aItems = new int[] {5, 7, 9, 10, 7, 6};
		
		for(int item : aItems) {
			l1.append(item);
		}
		
		LinkedList l2 = new LinkedList();
		int[] bItems = new int[] {6, 8, 10, 7, 6};
		
		for(int item : bItems) {
			l2.append(item);
		}
		
		Node n = getIntersection(l1.header.next, l2.header.next);	
		if(n != null) {
			System.out.print("Intersection : " + n.data);
		} else {
			System.out.print("Not found");
		}
	
		
	}
	
	static int lengthOfList(Node n) {
		int size = 0;
		while(n != null) {
			size ++;
			n = n.next;
		}
		return size;
	}	
	
	public static Node getIntersection(Node l1, Node l2) {
		
		int len1 = lengthOfList(l1);
		int len2 = lengthOfList(l2);
		
		if(len1 > len2) {
			l1 = getKthNode(l1, len1 - len2); // 차이만큼 이동한다.
		} else if(len1 < len2) {
			l2 = getKthNode(l2, len2 - len1);
		}
		
		while(l1 != null && l2 != null) {
			if(l1 == l2) { // 노드가 같은지 확인해준다.
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return null;
		
	}
	
	static Node getKthNode(Node head, int k) {
		Node current = head;
		while(k > 0 && current != null) {
			current = current.next;
			k --;
		}
		return current;
	}

}
