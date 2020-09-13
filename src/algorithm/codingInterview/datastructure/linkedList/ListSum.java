package algorithm.codingInterview.datastructure.linkedList;

import java.util.Scanner;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class ListSum {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static Node head = new Node();
	public static Node h = head;
	
	public static void main(String[] args) {
		
		LinkedList a = new LinkedList();
		
        String[] arrRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 3; j++) {
            int arrItem = Integer.parseInt(arrRowItems[j]);
            a.append(arrItem);
        }
        
        
        LinkedList b = new LinkedList();
        arrRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int j = 0; j < 3; j++) {
            int arrItem = Integer.parseInt(arrRowItems[j]);
            b.append(arrItem);
        }
        
        a.retrieve();
        b.retrieve();
        
//        int sum = getNumInLinkedList(a.header.next, b.header.next);
//        System.out.println(sum);
//        
//        setLinkedList(sum);
//        
//        Node result = head.next;
        
        Node result = addLists(a.header.next, b.header.next, 0);
        
        while(result.next != null) {
        	System.out.print(result.data + "->");
        	result = result.next;
        }
        System.out.print(result.data);
        
	}
	
	public static int getNumInLinkedList(Node aNode, Node bNode) {
		
		int digit = 1;
		
		int a = 0;
		while(aNode != null) {
			a += aNode.data * digit;
			digit *= 10;
			aNode = aNode.next;
		}
		
		int b = 0;
		digit = 1;
		while(bNode != null) {
			b += bNode.data * digit;
			digit *= 10;
			bNode = bNode.next;
		}
		
		int sum = a + b;
		
		return sum;
	}
	
	public static int setLinkedList(int quot) {
		
		if(quot == 0) {
			return -1;
		}
		
		int digit = setLinkedList(quot / 10);
		
		digit = quot % 10;
		
		Node n = new Node();
		n.data = digit;
		
		h.next = n;
		h = h.next;	
		
		return quot%10;
		
	}
	
	public static Node addLists(Node l1, Node l2, int carry) {
		
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		Node result = new Node();
		int value = carry;
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		
		// carry 만 있고, l1, l2 는 없을경우 아래로직 안타고 바로 return result
		if(l1 != null || l2 != null) { 
			Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value > 10 ? 1 : 0);
			result.next = more;
		}
		// carry 만 있을 경우
		return result;
			
	}

}
