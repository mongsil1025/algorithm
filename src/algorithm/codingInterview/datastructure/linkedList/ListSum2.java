package algorithm.codingInterview.datastructure.linkedList;

import java.util.Scanner;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class ListSum2 {
	
	private static final Scanner scanner = new Scanner(System.in);
	
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
        
        Node result = addLists(a, b);
        
        while(result.next != null) {
        	System.out.print(result.data + " - > ");
        	result = result.next;
        }
        System.out.print(result.data);
	}
	
	static class PartialSum {
		public Node sum = null;
		public int carry = 0;
	}
	
	public static Node addLists(LinkedList l1, LinkedList l2) {
		
		int len1 = l1.length();
		int len2 = l2.length();
		
		// 짧은 리스트에 0 을 붙인다.
		if(len1 < len2) {
			l1.padList(len2 - len1);
		} else if (len2 < len1){
			l2.padList(len1 - len2);
		}
		
		PartialSum sum = addListsHelper(l1.header.next, l2.header.next);
		
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}
	
	public static PartialSum addListsHelper(Node n1, Node n2) {
		if(n1 == null && n2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListsHelper(n1.next, n2.next);
		
		int val = sum.carry + n1.data + n2.data;
		
		// 현재 자릿수를 합한 결과를 Node에 저장한다.
		Node result = insertBefore(sum.sum, val % 10) ;
		
		sum.sum = result;
		sum.carry = val / 10;
		return sum;
	}
	
	public static Node insertBefore(Node list, int data) {
		Node n = new Node(data);
		n.next = list;
		return n;
	}

}
