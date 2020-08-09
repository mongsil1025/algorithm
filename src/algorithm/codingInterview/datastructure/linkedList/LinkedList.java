package algorithm.codingInterview.datastructure.linkedList;

public class LinkedList {
	
	Node header; // 첫번째 노드를 가리키는 헤더
	
	// 노드 생성자
	static class Node {
		int data;
		Node next = null;
	}
	
	LinkedList() {
		header = new Node();
	}
	
	void append(int d) {
		Node end = new Node();
		end.data = d;
		
		Node n = header;
		while(n.next != null) {
			n = n.next;
		}		
		n.next = end;		
	}
	
	void delete(int d) {
		Node n = header;
		while(n.next != null) { // header는 값을 가지고 있지않기 때문에, n.next는 첫번째 노드를 가르키게 된다.
			if(n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = header.next;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.print(n.data);
		System.out.println();
	}

	public static void main(String args[]) {
		
		LinkedList ll = new LinkedList();
		
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		ll.delete(1);
		ll.retrieve();
		
	}

}

