package algorithm.codingInterview.datastructure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class SplitNode {

	public static void main(String args[]) throws IOException {
	
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		
		LinkedList linkedList = new LinkedList();
		
		for(String item : aItems) {				
			linkedList.append(Integer.parseInt(item));
		}
		
		Node result = partitionLinkedList2(linkedList.header.next, 5);
		while(result.next != null) {
			System.out.print(result.data + " -> ");
			result = result.next;
		}
		System.out.print(result.data);
		
	}
	
	public static LinkedList partitionLinkedList(LinkedList list, int pivot) {
		
		Node n = list.header;
		
		Node s1 = null;
		Node e1 = null; // 노드를 이어주기 위해서
		
		Node s2 = null;
		Node e2 = null;
		
		while(n != null) {
			
			Node next = n.next;
			n.next = null; // n 을 before/after에 넣기 위해서 next값을 지워준다.
			
			if(n.data < pivot) {
				if(s1 == null) {
					s1 = n;
					e1 = s1;
				} else {
					e1.next = n;
					e1 = n;
				}
			} else {
				if(s2 == null) {
					s2 = n;
					e2 = s2;
				} else {
					e2.next = n;
					e2 = n;
				}
			}
			n = next;
		}
		
		LinkedList result = new LinkedList();
		if(s1 == null) {
			result.header = s2;
			return result;
		}
		
		e1.next = s2;
		result.header = s1;
		
		return result;		
		
	}
	
	public static Node partitionLinkedList2(Node n, int pivot) {
		
		Node h = n;
		Node t = n;
		
		while (n != null) {
			
			Node next = n.next;
			n.next = null;
			
			if(n.data < pivot) {
				n.next = h;
				h = n;
			} else {
				t.next = n;
				t = n;
			}
			
			n = next;
		}
		
		t.next = null;
		
		return h;
		
	}	
	
	
}
