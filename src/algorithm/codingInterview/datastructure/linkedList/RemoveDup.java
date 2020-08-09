package algorithm.codingInterview.datastructure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class RemoveDup {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		
		LinkedList linkedList = new LinkedList();
		
		for(String item : aItems) {				
			linkedList.append(Integer.parseInt(item));
		}
		
//		LinkedList result = removeDup(linkedList);
		
		removeDup2(linkedList);
		linkedList.retrieve();
		
	}
	
	public static LinkedList removeDup(LinkedList linkedList) {
		
		HashSet<Integer> hashSet = new HashSet<>();
		
		Node n = linkedList.header;
		while(n.next != null) {
			
			// HASH에 이미 있다면
			if(hashSet.contains(n.next.data)) {
				if(n.next != null) {
					n.next = n.next.next;
				}
				
			} else {
				hashSet.add(n.next.data);
				n = n.next;
			}						
			
		}		
		return linkedList;		
	}
	
	public static void removeDup2(LinkedList linkedList) {
		
		Node n = linkedList.header;
		
		while(n != null) {
			Node r = n;
			while(r.next != null) {
				if(n.data == r.next.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			n = n.next;
		}
		
	}

}
