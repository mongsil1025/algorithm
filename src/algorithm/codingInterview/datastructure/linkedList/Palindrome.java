package algorithm.codingInterview.datastructure.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

class Result {
	public Result(Node head, boolean b) {
		this.node = head;
		this.result = b;			
	}
	public Node node;
	public boolean result;
}

public class Palindrome {
	
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		
		LinkedList linkedList = new LinkedList();
		
		for(String item : aItems) {				
			linkedList.append(Integer.parseInt(item));
		}
		
		System.out.print(isPalindromeRecursive(linkedList.header.next));
		
	}
	
	static boolean isPalindrome(Node head) {
		Node reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}
	
	static boolean isPalindromeRunner(Node head) {
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			
			slow = slow.next;
			fast = fast.next.next; // 2개 건너 뛴다.
		}
		if(fast != null) {
			slow = slow.next; // fast가 null이 아니라면 리스트의 총길이가 홀수라서 slow는 가운데에 와있으므로 비교할 필요없다.
		}
		while(slow != null) {
			if(slow.data != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	static int lengthOfList(Node n) {
		int size = 0;
		while(n != null) {
			size ++;
			n = n.next;
		}
		return size;
	}	
	
	static boolean isPalindromeRecursive(Node head) {
		int length = lengthOfList(head);
		return isPalindromeRecurse(head, length).result;		
	}
	

	static Result isPalindromeRecurse(Node head, int length) {
		if(head == null || length <= 0) {
			return new Result(head, true);
		} else if(length == 1) {
			return new Result(head.next, true);
		}
		
		// 부분 리스트를 재귀적으로 호출한다.
		Result res = isPalindromeRecurse(head.next, length - 2);
		
		if(!res.result || res.node == null) {
			return res;
		}
		
		res.result = (head.data == res.node.data);
		
		// 재귀가 끝난 뒤 문자는 앞의 방향으로 계속 진행해야 한다.
		res.node = res.node.next;			
		return res;			 
	}
	
	static Node reverseAndClone(Node node) {
		Node head = null;
		while(node != null) {
			// 노드를 앞으로 추가한다.
			Node n = new Node(node.data); // 데이터 복사
			n.next = head;
			head = n;
			
			node = node.next;
		}
		return head;
	}
	static boolean isEqual(Node one, Node two) {
		while(one != null && two != null) {
			if(one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		 
		return true;
	}

}
