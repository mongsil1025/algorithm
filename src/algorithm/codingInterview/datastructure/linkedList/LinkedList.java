package algorithm.codingInterview.datastructure.linkedList;

public class LinkedList {
	
	Node header; // 첫번째 노드를 가리키는 헤더
	
	// 노드 생성자
	static class Node {
		public Node() {

		}
		public Node(int data) {
			this.data = data;
		}
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
	
	Node get(int idx) {
		Node n = header.next;
		for(int i=0; i<idx; i++) {
			n = n.next;
		}
		return n;
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
	
	int length() {
		
		Node n = header;
		int len = 0;
		while(n.next != null) {
			len++;
			n = n.next;
		}
		
		return len;
	}
	
	void padList(int padding) {
		for(int i=0; i<padding; i++) {
			insertBefore(padding);
		}
	}
	
	// data 를 리스트 맽 앞에 붙인다.
	void insertBefore(int data) {
		Node n = new Node(data);
		n.next = this.header.next;
		this.header = n;
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

